package metrotoilet.metrotoilet.repositories
import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.*
import org.springframework.stereotype.Repository

@Repository
interface StationToiletRepository: JpaRepository<StationToilet, Int> {
    fun findAllByStationId(stationId: Int?): List<StationToilet> {
        return findAllByStationId(stationId)
    }

    fun deleteByStationId(stationId: Int) {
        return deleteByStationId(stationId)
    }
}