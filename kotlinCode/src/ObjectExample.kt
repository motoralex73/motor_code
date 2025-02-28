class Person(val s: List<Int>)

object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees)
        {
            println(person)
        }
    }
    fun sayHello() {
        println("Hello")
    }
    init {
        println("init")
    }
}

fun main() {
    val p = Payroll
    p.sayHello()
}
