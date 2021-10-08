package dev.alimansour.planradarassessment.data.local

import dev.alimansour.planradarassessment.data.local.entity.City
import dev.alimansour.planradarassessment.data.local.entity.Historical
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * WeatherApp Android Application developed by: Ali Mansour
 * ----------------- WeatherApp IS FREE SOFTWARE -------------------
 * https://www.alimansour.dev   |   mailto:dev.ali.mansour@gmail.com
 */
class LocalDataSourceImpl(private val database: WeatherDatabase) : LocalDataSource {
    override suspend fun addCity(city: City) {
        withContext(Dispatchers.IO) {
            database.cityDao().insert(city)
        }
    }

    override suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            database.cityDao().getCities()
        }

    override suspend fun addHistoricalData(list: List<Historical>) {
        withContext(Dispatchers.IO) {
            database.historicalDao().insertList(list)
        }
    }

    override suspend fun getHistoricalData(id: Int): List<Historical> =
        withContext(Dispatchers.IO) {
            database.historicalDao().getHistoricalData(id)
        }
}