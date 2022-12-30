package metrotoilet.metrotoilet.controllers

import metrotoilet.metrotoilet.services.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/metro")
class HttpController(private val service: Service) {
    @GetMapping("/station")
    fun getStations() {
        return service.findAllStation()
    }

    @GetMapping("/station/{station_code}")
    fun getStationInfo(@PathVariable("station_code") stationCode: String): String {
        return service.findOneStation()
    }
}