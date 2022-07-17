data class Person(val name: String, val age: Int? = null)

fun main() {
    val persons = listOf(Person("Alice"),Person("Mike",age = 23))
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    println("The oldest man is: $oldest")



}