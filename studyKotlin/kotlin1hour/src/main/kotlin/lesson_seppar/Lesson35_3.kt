package lesson_seppar

fun <T> searchMax(x: T, y: T, z: T) {
    val l = arrayListOf(x,y,z)
    println(l)
    l.stream()
        .sorted()

    println(l)
}



fun main() {
    searchMax(15,17,12)
}