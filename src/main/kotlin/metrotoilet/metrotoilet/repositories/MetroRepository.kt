package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MetroRepository: JpaRepository<Metro, Int> {
    fun findTopByLineCode(lineCode: String): Metro? {
        return findTopByLineCode(lineCode)
    }
}