package metrotoilet.metrotoilet.domains

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.*
import org.hibernate.annotations.*
import java.time.*

@Entity
@Table(name = "metro_toilet")
data class MetroToilet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Comment("노선코드")
    @Column(name = "line_code", nullable = false)
    var lineCode: String,

    @Comment("역코드")
    @Column(name = "station_code", nullable = false)
    var stationCode: String,

    @Comment("상세위치")
    @Column(name = "toilet_detail_location")
    var toiletDetailLocation: String?,

    @Comment("게이트내외구분")
    @Column(name = "toilet_gate_type")
    var toiletGateType: String?,

    @Comment("출구번호")
    @Column(name = "toilet_near_exit_number")
    var toiletNearExitNumber: String?,

    @Comment("지상구분")
    @Column(name = "toilet_floor_type")
    var toiletFloorType: String?,

    @Comment("역층")
    @Column(name = "toilet_floor")
    var toiletFloor: Int?,

    @Comment("남녀구분")
    @Column(name = "toilet_sex_type")
    var toiletSexType: String?,

    @Comment("화장실개수")
    @Column(name = "toilet_count")
    var toiletCount: Int?,

    @Comment("기저귀교환대개수")
    @Column(name = "toilet_diaper_count")
    var toiletDiaperCount: Int?,

    @Comment("철도운영기관코드")
    @Column(name = "operating_agency_code")
    var operatingAgencyCode: String?
) {
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        "",
        0,
        0,
        ""
    )
}