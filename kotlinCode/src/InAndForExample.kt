import java.util.*

fun main() {

    for (i in 1..3) println("i = $i")
    for (i in 100 downTo 1 step 15) println(i)

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) println("$letter = $binary")

    val list = arrayListOf("10", "11", "12")
    for ((ind, el) in list.withIndex()) println("$ind = $el")

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'  // включен в диапазон
    fun isNotDigit(c: Char) = c !in '0'..'9'                // не включен в диапазон

    println(isLetter('q'))
    println(isNotDigit('x'))

    print("Kotlin interval : ")
    println("Kotlin" in "Java".."Scala")
}