package lesson_seppar

import java.time.LocalDate
import java.time.LocalDateTime

fun main() {
    val a1 = 5
    val a2 = 7
    val a3 = 9

    println( listOf(a1,a2,a3).reduce { sum, e -> sum + e } )
    println( listOf(a1,a2,a3).reduce { sum, e -> sum * e } )

    val a = listOf(a1,a2,a3)
    println( "summa = ${a.sum()}" )

    val d = LocalDate.now()
    println(d)
    val t = LocalDateTime.now().toLocalTime()
    println(t)
}