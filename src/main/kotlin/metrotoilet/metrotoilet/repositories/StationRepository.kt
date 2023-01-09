package metrotoilet.metrotoilet.repositories

import metrotoilet.metrotoilet.domains.*
import metrotoilet.metrotoilet.repositories.dtos.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StationRepository: JpaRepository<Station, Int> {
    @Query(
        "SELECT new metrotoilet.metrotoilet.repositories.dtos.findAllResponseDto(s.id" +
        "     , s.lineCode" +
        "     , s.lineName" +
        "     , s.stationCode" +
        "     , s.stationName" +
        "     , s.stationOrder" +
        "     , s.regionCode" +
        "     , s.operatingAgencyCode" +
        "     , (SELECT COUNT(1) FROM StationToilet st WHERE st.stationId = s.id) toiletCount" +
        "     )" +
        "  FROM Station s" +
        " WHERE s.regionCode = COALESCE(:regionCode, s.regionCode)" +
        "   AND s.lineCode = COALESCE(:lineCode, s.lineCode)"
    )
    fun findAll(regionCode: String?, lineCode: String?): List<findAllResponseDto>

    fun findTopByLineCodeAndStationCode(lineCode: String, stationCode: String): Station? {
        return findTopByLineCodeAndStationCode(lineCode, stationCode)
    }
}