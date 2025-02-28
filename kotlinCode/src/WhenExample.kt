import java.lang.Exception
import java.lang.IllegalStateException

enum class Color(var r: Int, val g: Int, val b: Int) {
        RED(255, 0, 0), ORANGE(255, 165, 0),
        YELLOW(255, 255, 0), GREEN(0, 255, 0),
        BLUE(0, 0, 255), INDIGO(75, 0, 130), VIOLET(238, 130, 238);

        fun rgb() = (r * 256 + g) * 256 + b
    }

    fun getMnemoric(color: Color) =
        when (color) {
            Color.RED -> "Каждый"
            Color.ORANGE -> "охотник"
            Color.YELLOW -> "желает"
            Color.GREEN -> "знать"
            Color.BLUE -> "где"
            Color.INDIGO -> "сидит"
            Color.VIOLET -> "фазан"
        }

    fun getWarmth(color: Color) = when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "теплый"
        Color.GREEN -> "нейтральный"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "холодный"
    }

    fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Грязный цвет")
        }

    fun mixOpti(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.YELLOW) ||
            (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
            else -> throw Exception("Dirty color")
        }



interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalAccessException("Unknown expression")
    }

fun funInCollection() {
    val lst = listOf("orange","apple","lime")
    val param = "apple"
    if (param in lst) println("Hello $param")

    val map = mapOf(1 to "one", 2 to "two")
    for ((a,b) in map) println("$a -> $b")
    //(1..1_000_000_000_000_000_000).forEach { print("$it ") }
    val values = mapOf("email" to 1, "age" to 2)
    val email = values["email"] ?: throw IllegalStateException("Email is missing")
    val number = (123).toString()
    if (number is String) println(number)

}


fun main() {

//    println(getMnemoric(Color.INDIGO))
//    println(getWarmth(Color.ORANGE))
//    println("rgb = ${Color::rgb}")
//    println(mix(Color.YELLOW, Color.BLUE))
//    println(mixOpti(Color.YELLOW, Color.BLUE))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    funInCollection()

    val exToDo = TODO()


}
