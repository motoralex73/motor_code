package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

@Component
class ClassicalMusic: Music {
    override fun getSong() : List<String> {
        return listOf("Hungarian Rhapsody","Russian Rhapsody", "English Rhapsody")
    }
}
