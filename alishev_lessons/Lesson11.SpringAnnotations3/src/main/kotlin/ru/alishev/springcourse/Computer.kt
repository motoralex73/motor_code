package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Computer {
    private val id: Int = 1;
    private val musicPlayer : MusicPlayer

    @Autowired
    constructor(musicPlayer: MusicPlayer) {
        this.musicPlayer = musicPlayer
    }
    override fun toString() : String {
        return "Playing: ${musicPlayer.playMusic(EnumMusic.CLASSICAL)}"
    }
}
