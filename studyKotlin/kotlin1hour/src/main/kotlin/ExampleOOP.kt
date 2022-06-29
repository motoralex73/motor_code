enum class Animals {
    DOG, CAT, BEAR, LION;
    fun toLowerCase() = name.toLowerCase().capitalize()
}

data class Person1 (val firstName: String="Peter", val lastName: String="Patrink", val age: Int?=55) : ExampleInterface, DbConnection {

    override fun toString(): String {
        return "$firstName $lastName $age login=$login"
    }

    override fun getConnection(): String {
        return "Database was connection!"
    }

    override val sayHello: String = "Hello, my friend"

    var login: String? = null
    set(value) {
        if (value == null)
            field = "none"
        else field = value
    }
        get() {
            val loginField = field ?: "неизвестно"
            println("логин : $loginField")
            return field //значение переменной
        }
}

fun checkDataType(obj : Person1) {
    if (obj is ExampleInterface) { //проверка, принадлежит ли объект к интерфейсу
        obj.showHello()
        println("epta")
    }
    if (obj is DbConnection) {
        obj.getConnection()
    }
}

fun main() {
    val person1 = Person1("Alex","Pro",35)
    println(person1.firstName+" "+person1.lastName+" "+person1.age)
    val person2 = Person1("Vasya")
    println("${person2.showHello()} and ${person2.getConnection()}")
    person2.login

    checkDataType(person1)

    val animal = Animals.BEAR
    when(animal) {
        Animals.BEAR -> println(animal.toLowerCase())
    }
}
