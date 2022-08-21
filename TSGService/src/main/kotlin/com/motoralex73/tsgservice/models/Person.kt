package com.motoralex73.tsgservice.models

class Person {
    private var id: Int
    private var name: String
    private var age: Int
    private var email: String

    constructor(id: Int, name: String, age: Int, email: String) {
        this.id = id
        this.name = name
        this.age = age
        this.email = email
    }

    constructor() {
        id = 0
        name = "null"
        age = 0
        email = "null"
    }

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
