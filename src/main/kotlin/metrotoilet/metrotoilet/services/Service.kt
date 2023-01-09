package metrotoilet.metrotoilet.services

import metrotoilet.metrotoilet.adapters.*
import metrotoilet.metrotoilet.adapters.dtos.*
import metrotoilet.metrotoilet.domains.*
import metrotoilet.metrotoilet.repositories.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
    private val kricHttpAdapter: KricHttpAdapter,
    private val metroRepository: MetroRepository,
    private val metroToiletRepository: MetroToiletRepository
) {
    fun findAllStation(areaCode: String, lineCode: String) : StationResponseDto? {
        return kricHttpAdapter.requestStation(StationRequestDto(areaCode, lineCode))
    //        return metroRepository.findAll()
    }

//    fun findOneStationToilet(station_code: String) {
//        return metroToiletRepository.findOne()
//    }

    @Transactional
    fun syncStations() {
        val logger = LoggerFactory.getLogger(Service::class.java)
        logger.info("Start syncStation()")

        val stations = kricHttpAdapter.requestStation() ?: return

        val entities = mutableListOf<Metro>()

        for (station in stations.body) {
            val existsMetro: Metro? = metroRepository.findTopByLineCodeAndStationCode(station.lnCd, station.stinCd)

            logger.info("Sync station (line: {} station: {})", station.lnCd, station.stinCd)

            entities.add(Metro(
                id = existsMetro?.id,
                lineCode = station.lnCd,
                lineName = station.routNm,
                stationCode = station.stinCd,
                stationName = station.stinNm,
                stationOrder = station.stinConsOrdr,
                regionCode = station.mreaWideCd,
                operatingAgencyCode = station.railOprIsttCd
            ))
        }

        metroRepository.saveAll(entities)

        logger.info("Finish syncStation()")
    }

    @Transactional
    fun syncStationsToilet() {
        val logger = LoggerFactory.getLogger(Service::class.java)
        logger.info("Start syncStationsToilet()")

        val metros: List<Metro> = metroRepository.findAll()

        for (metro in metros) {
            val toilets = kricHttpAdapter.requestStationToilet(
                StationToiletRequestDto(
                    lnCd = metro.lineCode,
                    stinCd = metro.stationCode,
                    railOprIsttCd = metro.operatingAgencyCode
                )
            ) ?: continue

            logger.info("Sync toilet (metroId: {}, line: {}, station: {})", metro.id, metro.lineCode, metro.stationCode)

            val entities = mutableListOf<MetroToilet>()

            metroToiletRepository.deleteByMetroId(metro.id as Int)

            for (toilet in toilets.body ?: continue) {
                entities.add(
                    MetroToilet(
                        metroId = metro.id as Int,
                        toiletDetailLocation = toilet.dtlLoc,
                        toiletGateType = toilet.gateInotDvNm,
                        toiletNearExitNumber = toilet.exitNo,
                        toiletFloorType = toilet.grndDvNm,
                        toiletFloor = toilet.stinFlor,
                        toiletSexType = toilet.mlFmlDvNm,
                        toiletCount = toilet.toltNum,
                        toiletDiaperCount = toilet.diapExchNum,
                        operatingAgencyCode = toilet.railOprIsttCd
                    )
                )
            }

            metroToiletRepository.saveAll(entities)
        }

        logger.info("Finish syncStationsToilet()")
    }
}