package dev.alimansour.iweather.data.repository

import dev.alimansour.iweather.data.local.LocalDataSource
import dev.alimansour.iweather.data.local.entity.City
import dev.alimansour.iweather.data.local.entity.Historical
import dev.alimansour.iweather.data.remote.RemoteDataSource
import dev.alimansour.iweather.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * WeatherApp Android Application developed by: Ali Mansour
 * ----------------- WeatherApp IS FREE SOFTWARE -------------------
 * https://www.alimansour.dev   |   mailto:dev.ali.mansour@gmail.com
 */
class WeatherRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    WeatherRepository {
    override suspend fun addCity(cityName: String) {
        withContext(Dispatchers.IO) {
            runCatching {
                val dataList = ArrayList<Historical>()
                val resource = remoteDataSource.fetchHistoricalData(cityName)
                resource.data?.let { response ->
                    val city = City(
                        response.city.id,
                        response.city.name,
                        response.city.country
                    )
                    localDataSource.addCity(city)
                    response.list?.let { list ->
                        list.forEach { item ->
                            dataList.add(
                                Historical(
                                    0,
                                    city,
                                    item.weather[0].icon,
                                    item.date,
                                    item.weather[0].description,
                                    item.main.temp,
                                    item.main.humidity,
                                    item.wind.speed
                                )
                            )
                        }

                        localDataSource.addHistoricalData(dataList)
                    }
                }


            }.onFailure { t -> Timber.e(t.message) }
        }
    }

    override suspend fun getCities(): List<City> = localDataSource.getCities()

    override suspend fun addHistoricalData(list: List<Historical>) =
        localDataSource.addHistoricalData(list)

    override suspend fun getHistoricalData(id: Int): List<Historical> =
        localDataSource.getHistoricalData(id)
}