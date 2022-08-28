package com.motoralex73.tsgservice.controllers;

import com.motoralex73.tsgservice.dao.PersonDAO
import com.motoralex73.tsgservice.models.Person
import com.motoralex73.tsgservice.repos.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
//@RequestMapping("/people")
class PeopleController {

    @Autowired
    private lateinit var personRepo: PersonRepo

    //почему автоварит конструктор???
//    //@Autowired
//    constructor(personDAO: PersonDAO) {
//        this.personDAO = personDAO
//    }

//    @GetMapping()
//    fun index(model: Map<String, java.util.Object>) : String {
//        println("INDEX")
//        //model.addAttribute("people", personDAO.index())
//        return "/index"
//    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int, model: Model) : String{
        println("SHOW")
        model.addAttribute("person", personRepo.show(id))
        return "people/show";
    }

    @GetMapping("/new")
    fun newPerson(@ModelAttribute("person") person:Person) : String {
        println("NEW PERSON: ${person.getName()}")
        return "people/new"
    }

    @PostMapping()
    fun create(@ModelAttribute("person") person: Person) : String {
        println("CREATE: ${person.getName()}")
        personRepo.save(person)
        return "redirect:/people"
    }

    @GetMapping("/{id}/edit")
    fun edit(model: Model, @PathVariable("id") id: Int) : String {
        println("EDIT")
        model.addAttribute("person", personRepo.show(id))
        return "people/edit"
    }

    @PatchMapping("/{id}")
    fun update(@ModelAttribute("person") person: Person, @PathVariable("id") id: Int) : String {
        println("UPDATE")
        personRepo.update(id, person)
        return "redirect:/people"
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) : String {
        println("DELETE")
        personRepo.delete(id)
        return "redirect:/people"
    }

    @PostMapping("filter")
    fun filter(@RequestParam filter: String?, model: MutableMap<String?, Any?>): String? {
        val persons: Iterable<Person>
        if (filter != null && !filter.isEmpty()) {
            persons = personRepo.findByTag(filter)
        } else {
            persons = personRepo.findAll()
        }
        model.put("persons", persons)
        return "people/main"
    }


}
