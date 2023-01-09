package metrotoilet.metrotoilet.domains
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.*
import org.hibernate.annotations.Comment

@Entity
@Table(name = "station")
data class Station(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Comment("노선코드")
    @Column(name = "line_code", nullable = false)
    var lineCode: String,

    @Comment("노선명")
    @Column(name = "line_name")
    var lineName: String,

    @Comment("역코드")
    @Column(name = "station_code", nullable = false)
    var stationCode: String,

    @Comment("역명")
    @Column(name = "station_name")
    var stationName: String,

    @Comment("역구성순서")
    @Column(name = "station_order")
    var stationOrder: Int,

    @Comment("권역코드")
    @Column(name = "region_code")
    var regionCode: String,

    @Comment("철도운영기관코드")
    @Column(name = "operating_agency_code")
    var operatingAgencyCode: String
) {
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        0,
        "",
        ""
    )
}