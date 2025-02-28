//циклы
fun main() {
    //for each
    val items = listOf("apple", "banana", "orange") //List.of() Java 9
    //mutableListOf("apple","banana","orange") //ArrayList
    for (it in items) println(it)
    //while
    var index = 0
    while (index < items.size) {
        println("Item at $index is ${items[index]}")
        index++
    }
    //диапазоны
    println(5 in 3..10) //true
    for (i in 1..10) print("$i ")
    println()
    for (i in 1 until 10) // выводит диапазон от 1..9 не включительно 10 (until)
        print("$i-")
    println()
    for (i in 10 downTo 1) print("$i ")
    println()
    for (i in 1..100 step 10) print("$i ")
}