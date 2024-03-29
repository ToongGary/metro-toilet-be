package metrotoilet.metrotoilet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class MetroToiletApplication

fun main(args: Array<String>) {
	runApplication<MetroToiletApplication>(*args)
}
