
fun main() {

    val mass = arrayListOf(1,2,3,4,5,6,7,'A'.toInt(),'B'.toInt(),'C'.toInt())
    println("массив всех чисел = $mass")
    val lamda = {
        val select_che = mass.filter { e -> e % 2 == 0 } //фуильтруем только четные числа
        println("массив четных чисел = $select_che")
        val s1 = select_che.sum() //находим сумму четных чисел
        println("сумма четных чисел = $s1")

        val select_neche = mass.filter { e -> e % 2 != 0 } //фуильтруем только четные числа
        println("массив нечетных чисел = $select_neche")
        val s2 = select_neche.sum() //находим сумму четных чисел
        println("сумма нечетных чисел = $s2")



    }

    lamda()
}

