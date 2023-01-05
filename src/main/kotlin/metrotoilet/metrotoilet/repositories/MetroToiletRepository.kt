package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.*
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MetroToiletRepository: JpaRepository<MetroToilet, Int> {
    fun findTopByLineCode(lineCode: String): MetroToilet? {
        return findTopByLineCode(lineCode)
    }
}