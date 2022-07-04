//лямбды и простые сортировки
fun main() {
    val a = listOf(1,2,3,4,5)

    a.forEach { e -> print("$e ") }
    println()
    println( a.map { e -> e*2 } )
    println( a.filter { e ->e % 2 == 0 } )
    println( a.reduce { sum, e -> sum + e} ) //просуммирует все элементы списка

    //a.sorted() // сортировка
    //a.sortedDescending {it} //сортирует на убывание

    a.any { it > 10 } //false, возвращает true, если есть хотя бы один элемент удовлетворяющий условию
    a.all { it < 10 } //true, возвращает true, если все элементы удовлетворяют условию
    a.sum() //суммирует все элементы в коллекции

    val numbers = listOf(1,3,-4,-2,-11)
    val (positive,negative) = numbers.partition { it > 0 } //делит коллекцию на 2 списка
    println(positive)
    println(negative)

    val result = listOf("a","b","ba","ccc","as").groupBy { it.length }
    println(result) //HashMap или LinkedHashMap

}