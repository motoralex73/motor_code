package com.motoralex73.tsgservice.repos
import com.motoralex73.tsgservice.models.Person


interface PersonRepo : CrudRepository<Person, Long> {
    fun findById(Id: Long): List<Person>?
}
