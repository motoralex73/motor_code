//пример производного класса
open class Base(name: String) {

    init { println("Инициализация класса Base") }
    open val size: Int =
        name.length.also { println("Инициализация свойства size в класса Base: $it") }
}

class Derived(
    name: String,
    lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Аргументы, переданные в конструктор класса Base: $it") }) {

    init { println("Инициализация класса Derived") }
    override val size: Int =
        (super.size + lastName.length).also { println("Инициализация свойства size в классе Derived: $it") }
}

fun main() {
    println("Построение класса Derived(\"hello\", \"world\")")
    Derived("hello", "world")
}