package metrotoilet.metrotoilet.services

import metrotoilet.metrotoilet.adapters.*
import metrotoilet.metrotoilet.domains.*
import metrotoilet.metrotoilet.repositories.*
import org.springframework.stereotype.Service

@Service
class Service(
    private val kricHttpAdapter: KricHttpAdapter,
    private val metroRepository: MetroRepository,
    private val metroToiletRepository: MetroToiletRepository
) {
    fun findAllStation(line_code: String) {
//        return metroRepository.findAll()
    }

    fun findOneStationToilet(station_code: String) {
//        return metroToiletRepository.findOne()
    }

    fun syncStations(line_code: String?) {
        val stations = kricHttpAdapter.requestStation()
//        metroRepository.updateOne(stations)
    }

    fun syncStationsToilet(line_code: String?, station_code: String?) {
        val stations = kricHttpAdapter.requestStation()

        if (stations != null) {
            for (station in stations.body) {
//                val toilet = kricHttpAdapter.requestStationToilet(station)
//            metroRepository.updateOne(toilet)
            }
        }
    }
}