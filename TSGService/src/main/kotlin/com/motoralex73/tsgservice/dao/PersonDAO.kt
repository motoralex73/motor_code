package com.motoralex73.tsgservice.dao;

import com.motoralex73.tsgservice.models.Person;
import org.springframework.stereotype.Component;
import kotlin.collections.ArrayList

@Component
class PersonDAO {
    var peopleCount: Int = 0
    var people: ArrayList<Person> = arrayListOf(
            Person(++peopleCount, "Tom", 24, "tom@mail.ru"),
            Person(++peopleCount, "Bob", 52, "bob@mail.ru"),
            Person(++peopleCount, "Mike", 18, "mike@yahoo.com"),
            Person(++peopleCount, "Katy", 34, "katy@gmail.com"))

    fun index(): ArrayList<Person> {
        return people;
    }

    fun  show(id: Int): Person {
        return people.stream().filter { people -> people.getId() == id }.findAny().orElse(null)
    }

    fun save(person: Person) {
        person.setId(++peopleCount)
        people.add(person)
    }

    fun update(id: Int, updatedPerson: Person) {
        val personToBeUpdated: Person = show(id)

        personToBeUpdated.setName(updatedPerson.getName())
        personToBeUpdated.setAge(updatedPerson.getAge())
        personToBeUpdated.setEmail(updatedPerson.getEmail())
    }

    fun delete(id: Int) {
        people.removeIf { p -> p.getId() == id }
    }
}
