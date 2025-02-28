fun testWhen(input: Any) {
    when (input) {
        1 -> println("Единица")
        2 -> println("Двойка")
        in 10..20 -> println("от 10 до 20")
        is String -> println("Была введена строка длиной ${input.length}")
        else -> println("Что-то еще")
    }
}

fun main() {
    testWhen(1)
    testWhen("String")
    testWhen(15)
}