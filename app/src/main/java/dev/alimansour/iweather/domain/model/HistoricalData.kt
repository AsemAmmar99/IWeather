package dev.alimansour.iweather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * WeatherApp Android Application developed by: Ali Mansour
 * ----------------- WeatherApp IS FREE SOFTWARE -------------------
 * https://www.alimansour.dev   |   mailto:dev.ali.mansour@gmail.com
 */

@Parcelize
data class HistoricalData(
    val id: Int,
    val city: CityData,
    val icon: String,
    val date: String,
    val description: String,
    val temperature: Double,
    val humidity: Double,
    val windSpeed: Double,
) : Parcelable