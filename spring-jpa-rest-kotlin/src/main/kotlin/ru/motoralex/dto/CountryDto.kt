package ru.motoralex.dto

//объект для пересылки данных о странах
data class CountryDto(
    val id: Int? = null,
    val name: String,
    val population: Int,
    val cities: List<CityDto>
)
