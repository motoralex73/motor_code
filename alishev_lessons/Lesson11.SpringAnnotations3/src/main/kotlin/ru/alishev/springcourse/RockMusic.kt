package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

@Component
class RockMusic : Music {
    override fun getSong() : List<String> {
        return listOf("Wind cries Mary","Wind cries Harry","Wind cries Tom")
    }
}
