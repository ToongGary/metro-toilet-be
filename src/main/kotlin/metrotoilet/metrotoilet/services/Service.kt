package metrotoilet.metrotoilet.services

import metrotoilet.metrotoilet.adapters.*
import metrotoilet.metrotoilet.adapters.dtos.*
import metrotoilet.metrotoilet.domains.Station
import metrotoilet.metrotoilet.domains.StationToilet
import metrotoilet.metrotoilet.repositories.*
import metrotoilet.metrotoilet.repositories.dtos.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class Service(
    private val kricHttpAdapter: KricHttpAdapter,
    private val stationRepository: StationRepository,
    private val stationToiletRepository: StationToiletRepository
) {
    fun findAllStation(regionCode: String?, lineCode: String?) : List<findAllResponseDto>? {
        return stationRepository.findAll(regionCode, lineCode)
    }

    fun findAllStationToilet(stationId: Int?): List<StationToilet> {
        return stationToiletRepository.findAllByStationId(stationId)
    }

    @Transactional
    fun syncStations() {
        val logger = LoggerFactory.getLogger(Service::class.java)
        logger.info("Start syncStation()")

        val stations = kricHttpAdapter.requestStation() ?: return

        val entities = mutableListOf<Station>()

        for (station in stations.body) {
            val existsStation: Station? = stationRepository.findTopByLineCodeAndStationCode(station.lnCd, station.stinCd)

            logger.info("Sync station (line: {} station: {})", station.lnCd, station.stinCd)

            entities.add(
                Station(
                    id = existsStation?.id,
                    lineCode = station.lnCd,
                    lineName = station.routNm,
                    stationCode = station.stinCd,
                    stationName = station.stinNm,
                    stationOrder = station.stinConsOrdr,
                    regionCode = station.mreaWideCd,
                    operatingAgencyCode = station.railOprIsttCd
                )
            )
        }

        stationRepository.saveAll(entities)

        logger.info("Finish syncStation()")
    }

    @Transactional
    fun syncStationsToilet() {
        val logger = LoggerFactory.getLogger(Service::class.java)
        logger.info("Start syncStationsToilet()")

        val stations: List<Station> = stationRepository.findAll()

        for (station in stations) {
            val toilets = kricHttpAdapter.requestStationToilet(
                StationToiletRequestDto(
                    lnCd = station.lineCode,
                    stinCd = station.stationCode,
                    railOprIsttCd = station.operatingAgencyCode
                )
            ) ?: continue

            logger.info("Sync toilet (stationId: {}, line: {}, station: {})", station.id, station.lineCode, station.stationCode)

            val entities = mutableListOf<StationToilet>()

            stationToiletRepository.deleteByStationId(station.id as Int)

            for (toilet in toilets.body ?: continue) {
                entities.add(
                    StationToilet(
                        stationId = station.id as Int,
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

            stationToiletRepository.saveAll(entities)
        }

        logger.info("Finish syncStationsToilet()")
    }
}