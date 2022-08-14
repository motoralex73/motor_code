package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MusicPlayer {
    @Autowired
    private lateinit var rockMusic: RockMusic
    @Autowired
    private lateinit var classicalMusic: ClassicalMusic

    fun playMusic(e: EnumMusic) : String {
        when(e) {
            EnumMusic.CLASSICAL -> {
                val list = classicalMusic.getSong()
                return list.random()
            }
            else -> {
                val list = rockMusic.getSong()
                return list.random()
            }
        }

        return "Playing: " + rockMusic.getSong() + ", " + classicalMusic.getSong();
    }
}

