package metrotoilet.metrotoilet.repositories
import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.*
import org.springframework.stereotype.Repository

@Repository
interface StationToiletRepository: JpaRepository<StationToilet, Int> {
    fun deleteByMetroId(metroId: Int) {
        return deleteByMetroId(metroId)
    }
}