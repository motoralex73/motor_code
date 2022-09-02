package ru.motoralex.entity

import java.util.Collections.emptyList
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

//сущность-таблица стран в базе данных со связями один к многим
@Entity
@Table(name = "country")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var population: Int = 0,
    @OneToMany(mappedBy = "country")
    var cities: List<CityEntity> = emptyList()
)
