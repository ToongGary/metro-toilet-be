package metrotoilet.metrotoilet.domains

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment

@Entity
@Table(name = "metro_toilet")
data class MetroToilet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Comment("노선코드")
    @Column(name = "line_code", nullable = false)
    val lineCode: Int,

    @Comment("역코드")
    @Column(name = "station_code", nullable = false)
    val stationCode: String,

    @Comment("상세위치")
    @Column(name = "toilet_detail_location", nullable = false)
    val toiletDetailLocation: String,

    @Comment("게이트내외구분")
    @Column(name = "toilet_gate_type", nullable = false)
    val toiletGateType: String,

    @Comment("출구번호")
    @Column(name = "toilet_near_exit_number", nullable = false)
    val toiletNearExitNumber: Int,

    @Comment("지상구분")
    @Column(name = "toilet_floor_type", nullable = false)
    val toiletFloorType: String,

    @Comment("역층")
    @Column(name = "toilet_floor", nullable = false)
    val toiletFloor: Int,

    @Comment("남녀구분")
    @Column(name = "toilet_sex_type", nullable = false)
    val toiletSexType: String,

    @Comment("화장실개수")
    @Column(name = "toilet_count", nullable = false)
    val toiletCount: Int,

    @Comment("기저귀교환대개수")
    @Column(name = "toilet_diaper_count", nullable = false)
    val toiletDiaperCount: Int,

    @Comment("철도운영기관코드")
    @Column(name = "operating_agency_code", nullable = false)
    val operatingAgencyCode: String
)