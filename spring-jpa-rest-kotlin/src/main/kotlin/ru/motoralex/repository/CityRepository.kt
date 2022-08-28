package ru.motoralex.repository

import org.springframework.data.repository.CrudRepository
import ru.motoralex.entity.CityEntity
import ru.motoralex.entity.CountryEntity

interface CityRepository: CrudRepository<CityEntity, Int> {

    fun deleteAllByCountry(country: CountryEntity)
}