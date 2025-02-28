
fun fail(message: String): Nothing {
   throw IllegalAccessException(message)
}

fun main() {
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false

    val myTrue: Boolean = true
    val myFalse: Boolean = false
    val boolNull: Boolean? = null

    println(myTrue || myFalse)
    println(myTrue && myFalse)
    println(!myTrue)

    var str = "abcd123"
    str += "hello"
    println(str)
    for (c in str) if (c != str[str.length-1]) print("$c-")
    else print("$c")
//приведение типа string -> int, если не получилось, то null
// as? - оператор безопасного приведения
    val bInt: Int? = str as? Int
    println("\n")
    println(bInt.toString())

    println(str.reversed())

    fail("HELLO")
}

