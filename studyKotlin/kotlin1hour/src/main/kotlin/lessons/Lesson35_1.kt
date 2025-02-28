package lessons

abstract class Summa(val a1: Int, val a2: Int, val a3: Int) {
    fun sum1() = a1 + a2 + a3
}

fun main() {
    val a1 = 5
    val a2 = 7
    val a3 = 9

    println(listOf(a1, a2, a3).reduce { sum, e -> sum + e })
    println(listOf(a1, a2, a3).reduce { sum, e -> sum * e })

//    val s1 = Summa(a1,a2,a3) -> {
//        return a1+a2+a3
//    }


}