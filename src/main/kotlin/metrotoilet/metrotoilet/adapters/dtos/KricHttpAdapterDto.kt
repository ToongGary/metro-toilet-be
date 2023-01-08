package metrotoilet.metrotoilet.adapters.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class StationRequestDto(
    val mreaWideCd: String?,
    val lnCd: String?
)

data class StationResponseDto(
    @JsonProperty("header") val header: Header,
    @JsonProperty("body") val body: List<Station>
)

data class StationToiletRequestDto(
    val lnCd: String?,
    val stinCd: String?,
    val railOprIsttCd: String?
)

data class StationToiletResponseDto(
    @JsonProperty("header") val header: Header,
    @JsonProperty("body") val body: List<StationToilet>?
)

data class Header(
    @JsonProperty("resultCnt") val resultCnt: Int,
    @JsonProperty("resultCode") val resultCode: String,
    @JsonProperty("resultMsg") val resultMsg: String
)

data class Station(
    @JsonProperty("mreaWideCd") val mreaWideCd: String,
    @JsonProperty("routCd") val routCd: String,
    @JsonProperty("routNm") val routNm: String,
    @JsonProperty("stinConsOrdr") val stinConsOrdr: Int,
    @JsonProperty("railOprIsttCd") val railOprIsttCd: String,
    @JsonProperty("lnCd") val lnCd: String,
    @JsonProperty("stinCd") val stinCd: String,
    @JsonProperty("stinNm") val stinNm: String
)

data class StationToilet(
    @JsonProperty("railOprIsttCd") val railOprIsttCd: String?,
    @JsonProperty("lnCd") val lnCd: String,
    @JsonProperty("stinCd") val stinCd: String,
    @JsonProperty("grndDvNm") val grndDvNm: String?,
    @JsonProperty("stinFlor") val stinFlor: Int?,
    @JsonProperty("gateInotDvNm") val gateInotDvNm: String?,
    @JsonProperty("exitNo") val exitNo: String?,
    @JsonProperty("dtlLoc") val dtlLoc: String?,
    @JsonProperty("mlFmlDvNm") val mlFmlDvNm: String?,
    @JsonProperty("toltNum") val toltNum: Int?,
    @JsonProperty("diapExchNum") val diapExchNum: Int?
)