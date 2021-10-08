package dev.alimansour.planradarassessment.data.remote

import androidx.lifecycle.LiveData
import dev.alimansour.planradarassessment.data.remote.response.HistoricalResponse
import dev.alimansour.planradarassessment.util.Resource

/**
 * WeatherApp Android Application developed by: Ali Mansour
 * ----------------- WeatherApp IS FREE SOFTWARE -------------------
 * https://www.alimansour.dev   |   mailto:dev.ali.mansour@gmail.com
 */
interface NetworkDataSource {

    /**
     * Fetch historical weather data for specific city
     * @param cityName City Name
     * @return Resource<HistoricalResponse>
     */
    suspend fun fetchHistoricalData(cityName: String): Resource<HistoricalResponse>
}