package metrotoilet.metrotoilet.controllers

import metrotoilet.metrotoilet.domains.*
import metrotoilet.metrotoilet.repositories.dtos.*
import metrotoilet.metrotoilet.services.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/metro")
class HttpController(private val service: Service) {
    @GetMapping("/station")
    fun getStations(
        @RequestParam regionCode: String?,
        @RequestParam lineCode: String?
    ) : List<findAllResponseDto>? {
        return service.findAllStation(regionCode, lineCode);
    }

    @GetMapping("/station/toilet/{stationId}")
    fun getStationToilets(@PathVariable(value = "stationId") stationId: Int) : List<StationToilet> {
        return service.findAllStationToilet(stationId)
    }
}