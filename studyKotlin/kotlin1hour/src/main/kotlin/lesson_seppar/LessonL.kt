package lesson_seppar

interface Summa {
    var a1: Int
    var a2: Int
    var a3: Int

    fun sum(a1: Int, a2: Int, a3: Int): Int

}


fun main() {
    var a1 = 5
    var a2 = 6
    var a3 = 7

    print("Enter operation: ")
    val sum = { x: Int, y: Int, z: Int ->
        when (readLine()) {
            "+" -> x + y + z
            "-" -> x - y - z
            "*" -> x * y * z
            "/" -> x / y / z
            else -> {
                println("error symbol operation")
            }
        }
    }
    println(sum(a1, a2, a3))

//    val multiply = {x:Int,y:Int,z:Int -> x*y*z}


}