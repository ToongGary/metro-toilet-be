package metrotoilet.metrotoilet.repositories.dtos

data class findAllResponseDto(
    var id: Int,
    var lineCode: String?,
    var lineName: String?,
    var stationCode: String?,
    var stationName: String?,
    var stationOrder: Int?,
    var regionCode: String?,
    var operatingAgencyCode: String?,
    val toiletCount: Long?
)