package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.*
import org.springframework.stereotype.Repository

@Repository
interface MetroToiletRepository: JpaRepository<MetroToilet, Int> {
    fun deleteByMetroId(metroId: Int) {
        return deleteByMetroId(metroId)
    }
}