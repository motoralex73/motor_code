package ru.motoralex73.smlr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmlrApplication

fun main(args: Array<String>) {
	runApplication<SmlrApplication>(*args)
}
