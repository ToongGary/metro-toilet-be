package metrotoilet.metrotoilet.adapters

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.core.type.TypeReference
import metrotoilet.metrotoilet.adapters.dtos.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate

@Component
class KricHttpAdapter(
    private val jacksonObjectMapper: ObjectMapper,
    @Value("\${api.kric.station.endpoint}") val stationApiEndpoint: String,
    @Value("\${api.kric.station.key}") val stationApiKey: String,
    @Value("\${api.kric.stationToilet.endpoint}") val stationToiletApiEndpoint: String,
    @Value("\${api.kric.stationToilet.key}") val stationToiletApiKey: String
) {
    fun requestStation(
        stationRequestDto: StationRequestDto = StationRequestDto("", "")
    ): StationResponseDto? {
        val url = getRequestUrl(
            stationApiEndpoint,
            stationApiKey,
            stationRequestDto
        )
        println(url)
        return request<StationResponseDto>(url)
    }

    fun requestStationToilet(
        stationToiletRequestDto: StationToiletRequestDto = StationToiletRequestDto("", "", "")
    ): StationToiletResponseDto? {
        val url = getRequestUrl(
            stationToiletApiEndpoint,
            stationToiletApiKey,
            stationToiletRequestDto
        )
        println(url)
        return request<StationToiletResponseDto>(url)
    }

    private fun getRequestUrl(endpoint: String, key: String, dto: Any): String { // LinkedMultiValueMap<String, String> {
        val params = LinkedMultiValueMap<String, String>()
        val map = jacksonObjectMapper.convertValue(dto, object : TypeReference<Map<String, String>>() {})
        params.setAll(map)

        val queryString = StringBuilder()
        queryString.append("serviceKey=$key&")
        queryString.append("format=json&")

        for ((k, v) in map.entries) {
            queryString.append("$k=$v&")
        }

        return "$endpoint?$queryString"
    }

    private inline fun <reified T> request(url: String): T {
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity(url, String::class.java)

        val responseBody = response.body!!
        return jacksonObjectMapper.readValue(responseBody, T::class.java)
    }
}