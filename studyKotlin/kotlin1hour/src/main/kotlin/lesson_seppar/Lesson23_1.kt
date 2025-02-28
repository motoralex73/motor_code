fun main() {
    var listDigital: ArrayList<Any> = arrayListOf()
    println("Enter digital number (q-exit):")

    var p: String? = "";
    while (p.equals("q").not()) {
        p = readLine()
        if (p != null && (p != "q")) {
            listDigital.add(p)
        }
    }
    println(listDigital)

    println("Выберите действие:")
    println("1.Добавить")
    println("2.Удалить")
    println("3.Показать список")
    println("4.Проверить значение")
    println("5.Заменить значение в списке")
    println("q - exit")

    when (readLine()) {
        "1" -> {
            p = readLine()
            if (p != null && (p != "q")) {
                listDigital.add(p)
                println(listDigital)
            }
        }
        "2" -> searchElement(listDigital, "2")
        "3" -> println(listDigital)
        "4" -> searchElement(listDigital, "4")
        "5" -> searchElement(listDigital, "5")
        else -> println("Введите нормальный параметр")
    }
}

fun searchElement(listDigital: ArrayList<Any>, s: String) {
    println(listDigital)

    if (s == "2") println("Введите элемент для удаления из списка:")
    if (s == "4") println("Введите элемент для поиска в списке:")
    if (s == "5") println("Введите элемент для замены в списке:")

    val p = readLine()
    var count = 0
    for (i in listDigital) {
        if (i == p) {
            if (s == "2")
                listDigital.remove(i)
            if (s == "4")
                println("Элемент найден, его индекс: $count")
            if (s == "5")
                listDigital[count] = "555"
            break
        }
        count++
    }
    println(listDigital)
}
