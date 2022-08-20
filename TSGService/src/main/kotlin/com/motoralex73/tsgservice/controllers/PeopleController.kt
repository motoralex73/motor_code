package com.motoralex73.tsgservice.controllers;

import com.motoralex73.tsgservice.dao.PersonDAO
import com.motoralex73.tsgservice.models.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/people")
class PeopleController {

    private var personDAO: PersonDAO

    @Autowired
    constructor( personDAO: PersonDAO) {
        this.personDAO = personDAO
    }

    @GetMapping()
    fun index(model: Model) : String {
        model.addAttribute("people", personDAO.index())
        return "people/index"
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int, model: Model) : String{
        model.addAttribute("person", personDAO.show(id))
        return "people/show";
    }

    @GetMapping("/new")
    fun newPerson(@ModelAttribute("person") person: Person) : String {
        return "people/new"
    }

    @PostMapping()
    fun create(@ModelAttribute("person") person: Person) : String {
        personDAO.save(person)
        return "redirect:/people"
    }

    @GetMapping("/{id}/edit")
    fun edit(model: Model, @PathVariable("id") id: Int) : String {
        model.addAttribute("person", personDAO.show(id))
        return "people/edit"
    }

    @PatchMapping("/{id}")
    fun update(@ModelAttribute("person") person: Person, @PathVariable("id") id: Int) : String {
        personDAO.update(id, person)
        return "redirect:/people"
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) : String {
        personDAO.delete(id)
        return "redirect:/people"
    }
}
