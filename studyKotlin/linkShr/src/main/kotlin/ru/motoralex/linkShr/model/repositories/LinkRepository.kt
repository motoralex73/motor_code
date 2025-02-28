package ru.motoralex.linkShr.model.repositories

import org.springframework.context.annotation.Bean
import org.springframework.data.repository.Repository
import ru.motoralex.linkShr.model.Link
import java.beans.BeanProperty
import java.util.*

interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}