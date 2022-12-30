package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MetroRepository: JpaRepository<Metro, Int>