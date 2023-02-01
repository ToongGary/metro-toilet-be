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
                "     , COUNT(st.id) toiletCount" +
                "     , COALESCE(SUM(case when st.toiletGateType = '내' then 1 else 0 end), 0) toiletInGateCount" +
                "     )" +
                "  FROM Station s" +
                "  Left Join StationToilet st on st.stationId = s.id" +
                " WHERE s.regionCode = COALESCE(:regionCode, s.regionCode)" +
                "   AND s.lineCode = COALESCE(:lineCode, s.lineCode)" +
                " GROUP BY s.id")
    fun findAll(regionCode: String?, lineCode: String?): List<findAllResponseDto>

    fun findTopByLineCodeAndStationCode(lineCode: String, stationCode: String): Station? {
        return findTopByLineCodeAndStationCode(lineCode, stationCode)
    }
}