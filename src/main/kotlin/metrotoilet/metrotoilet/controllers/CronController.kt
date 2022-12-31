package metrotoilet.metrotoilet.controllers

import metrotoilet.metrotoilet.services.*
import org.springframework.stereotype.Controller
import org.springframework.scheduling.annotation.Scheduled

@Controller
class CronController(private val service: Service) {
//    @Scheduled(cron = "0 0 0/15 * * ?")
//    fun syncStations() {
//        return service.syncStations()
//    }

//    @Scheduled(cron = "0 0 0/15 * * ?")
//    fun syncStationsToilet() {
//        return service.syncStationsToilet()
//    }
}