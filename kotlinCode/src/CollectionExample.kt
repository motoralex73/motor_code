fun main() {

    val set = hashSetOf(1,7,23)
    val list = arrayListOf(1,5,7)
    val map = hashMapOf(1 to "one", 2 to "two", 7 to "seven")
    val strings = listOf("first", "second", "fourteenth")
    val numbers = setOf(1,25,5,7)

    val array = listOf<Any>("hello",1,2,3)

    println(map)
    println(strings.last())
    println(numbers.maxOrNull())
    println(array)

    val numb = (0..13).toList()
    println(numb.subList(3,6))


}