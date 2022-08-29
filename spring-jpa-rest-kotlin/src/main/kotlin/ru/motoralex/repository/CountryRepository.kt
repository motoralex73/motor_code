package ru.motoralex.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.motoralex.entity.CountryEntity
import ru.motoralex.model.NameOnly

interface CountryRepository : CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<CountryEntity>

    // найти все записи без фильтра и упорядочить по имени, по проекции их модели NameOnly, чтобы не тянуть все поля
    fun findAllByOrderByName(): List<NameOnly>
}
