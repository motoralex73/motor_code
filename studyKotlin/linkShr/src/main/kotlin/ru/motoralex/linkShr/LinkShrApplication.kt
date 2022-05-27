package ru.motoralex.linkShr

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class LinkShrApplication

fun main(args: Array<String>) {
	//runApplication<LinkShrApplication>(*args)
	SpringApplication.run(LinkShrApplication::class.java, *args)
}
