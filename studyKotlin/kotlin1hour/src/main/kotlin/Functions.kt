fun testSimple(x : Int, y : Int) = x + y

fun testString(x : Int) : String {
    return "Hello is $x"
}

fun testNamedArguments(x : Int, y: Int, z : Int) : List<Int> {
    return listOf(x,y,z)
}

//аргументы по умолчанию
fun testDefaultArguments(x : Int = 1, y: Int = 2) {
    println(x + y)
}

//замена перегрузки методов
fun foo(name : String, number : Int = 42, toUpperCase : Boolean = false) {
    (if (toUpperCase) name.toUpperCase() else name) + number
}

//vararg - передача в функцию множества агрументов
fun printEvent(vararg numbers : Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}

fun main() {
    println(testSimple(3,10))
    println(testString(111))
    println(testNamedArguments(z = 5, y = 3, x = 1))
    testDefaultArguments(x = 5,y = 7)
    println(foo("hello"))
    printEvent(1,2,3,4,5,6,7,8,9)
    printEvent(*intArrayOf(1,2,3,4,5,6,7,8,9,10)) //передаем массив чисел, поэлементно подставляя в функцию
}
