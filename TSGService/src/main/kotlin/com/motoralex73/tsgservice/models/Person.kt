package com.motoralex73.tsgservice.models

import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class Person {
    @NotEmpty(message = "Id should not be empty")
    private var id: Int = 0
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private var name: String = ""
    @Min(value = 0, message = "Age should be greater than 0")
    private var age: Int = 0
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private var email: String = ""

    constructor(id: Int, name: String, age: Int, email: String) {
        this.id = id
        this.name = name
        this.age = age
        this.email = email
    }

    constructor()

    fun setId(id: Int) {
        this.id = id
    }
    fun setName(name: String) {
        this.name = name
    }
    fun setAge(age: Int) {
        this.age = age
    }
    fun setEmail(email: String) {
        this.email = email
    }
    fun getId(): Int {
        return id
    }
    fun getName(): String {
        return name
    }
    fun getAge(): Int {
        return age
    }
    fun getEmail(): String {
        return email
    }

}
