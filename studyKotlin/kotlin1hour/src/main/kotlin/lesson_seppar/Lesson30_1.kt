import kotlin.collections.ArrayList

fun checkChe(arr: ArrayList<Int>) {
    print("Четные числа (кол-во): ")
    println(arr.count { e -> e % 2 == 0 })
    print("Нечетные числа (кол-во): ")
    println(arr.count { e -> e % 2 != 0 })
    print("Равные нулю (кол-во): ")
    println(arr.count { e -> e == 0 })
}

fun main() {
    var arr: ArrayList<Int> = ArrayList(100)
    var count = 1000
    while (count > 0) {
        arr.add((-1000..1000).random())
        count--
    }

    print("All random digital: ")
    println(arr)
    checkChe(arr)
    print("Введите число для проверки: ")
    val p = readLine()?.toInt() //with save call
    if (p != null) println(arr.count { e -> e == p.toInt() })

}