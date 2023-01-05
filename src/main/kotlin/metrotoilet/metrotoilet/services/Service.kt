package metrotoilet.metrotoilet.services

import com.mysql.cj.x.protobuf.*
import metrotoilet.metrotoilet.adapters.*
import metrotoilet.metrotoilet.adapters.dtos.*
import metrotoilet.metrotoilet.domains.*
import metrotoilet.metrotoilet.repositories.*
import org.hibernate.sql.Insert
import org.springframework.stereotype.Service

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

    fun syncStations() {
        val stations = kricHttpAdapter.requestStation() ?: return

        val entities = mutableListOf<Metro>()

        for (station in stations.body) {
            val existsMetro = metroRepository.findTopByLineCode(station.lnCd)

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
    }
    fun syncStationsToilet() {
        val stations: List<Metro> = metroRepository.findAll()

        val entities = mutableListOf<MetroToilet>()

        for (station in stations.slice(IntRange(0, 5))) {
            val toilets = kricHttpAdapter.requestStationToilet(
                StationToiletRequestDto(
                    lnCd = station.lineCode,
                    stinCd = station.stationCode,
                    railOprIsttCd = station.operatingAgencyCode
                )
            ) ?: continue

            for (toilet in toilets.body ?: continue) {
                val existsMetroToilet = metroToiletRepository.findTopByLineCode(toilet.lnCd)

                entities.add(
                    MetroToilet(
                        id = existsMetroToilet?.id,
                        lineCode = toilet.lnCd,
                        stationCode = toilet.stinCd,
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
        }

        println("Finish")
        metroToiletRepository.saveAll(entities)
    }
}