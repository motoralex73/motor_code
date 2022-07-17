package ru.motoralex73.smlr

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

@SpringBootApplication
open class SmlrApplication

fun main(args: Array<String>) {
	SpringApplication.run(SmlrApplication::class, *args)

}
