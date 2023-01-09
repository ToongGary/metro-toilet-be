package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StationRepository: JpaRepository<Station, Int> {
    fun findTopByLineCodeAndStationCode(lineCode: String, stationCode: String): Station? {
        return findTopByLineCodeAndStationCode(lineCode, stationCode)
    }
}