package com.motoralex73.tsgservice.dao;

import com.motoralex73.tsgservice.models.Person;
import com.motoralex73.tsgservice.repos.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component;
import kotlin.collections.ArrayList

@Component
class PersonDAO {
    var peopleCount: Int = 0
//    private var people: ArrayList<Person> = arrayListOf(
//            Person(++peopleCount, "Tom", 24, "tom@mail.ru"),
//            Person(++peopleCount, "Bob", 52, "bob@mail.ru"),
//            Person(++peopleCount, "Mike", 18, "mike@yahoo.com"),
//            Person(++peopleCount, "Katy", 34, "katy@gmail.com"))

    @Autowired
    private val personRepo: PersonRepo? = null

//    fun index(): ArrayList<Person> {
//        return people
//    }

    fun show(id: Int): Person {
        //временно
        return Person(++peopleCount, "Tom", 24, "tom@mail.ru")

        //return people.stream().filter { people -> people.getId() == id }.findAny().orElse(null)
    }

    fun save(person: Person) {
        println("SAVE PERSON")
        person.setId(++peopleCount)
        println("Save new Person: ${person.getName()}")
        personRepo.save(person)
    }

    fun update(id: Int, updatedPerson: Person) {
        val personToBeUpdated: Person = show(id)

        personToBeUpdated.setName(updatedPerson.getName())
        personToBeUpdated.setAge(updatedPerson.getAge())
        personToBeUpdated.setEmail(updatedPerson.getEmail())
    }

    fun delete(id: Int) {
        println("Delete people with id = $id")
        //people.removeIf { p -> p.getId() == id }
    }
}