package metrotoilet.metrotoilet.controllers

import metrotoilet.metrotoilet.services.*
import org.springframework.stereotype.Controller
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
class CronController(private val service: Service) {
    @Scheduled(cron = "0 0 0/15 * * ?")
    @GetMapping("/syncStations")
    fun syncStations() {
        return service.syncStations()
    }

    @Scheduled(cron = "0 0 0/15 * * ?")
    @GetMapping("/syncStationsToilet")
    fun syncStationsToilet() {
        return service.syncStationsToilet()
    }
}