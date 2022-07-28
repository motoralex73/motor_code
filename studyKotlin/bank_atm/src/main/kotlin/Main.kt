import kotlin.system.exitProcess

fun printAccount(str:String) {
    println("Меню $str:\n" +
            "1 - Просмотр баланса\n" +
            "2 - Снять средства\n" +
            "3 - Пополнить средства\n" +
            "4 - Выход")
}

fun mainAccount(bCard:Double, str:String):Double {
    printAccount("основного счета по всем ${str}ам")
    var balance = bCard
    var deleteMoney = 0.0
    var addMoney = 0.0

    when (readLine()!!.toInt()) {
        1 -> {
            println("Баланс ${str}: $balance")
        }
        2 -> {
            println(
                "Текущий баланс ${str}: $balance рублей\n" +
                        "Укажите сколько средств снять:"
            )
            deleteMoney = readLine()!!.toDouble()
            balance -= deleteMoney
            println("Баланс ${str}: $balance")
        }
        3 -> {
            println(
                "Текущий баланс ${str}: $balance рублей\n" +
                        "Укажите сколько средств добавить:"
            )
            addMoney = readLine()!!.toDouble()
            balance += addMoney
            println("Баланс ${str}: $balance")
        }
        4 -> exitProcess(4)
        else -> exitProcess(4)
    }
    return balance
}

fun bankService() {
    val atm = Atm()
    var correctCard = -1
    var count = 3
    var balanceCard: Double = 0.0 //карта
    var balanceBook: Double = 0.0 //сбер книжка

    while (0 >= correctCard) {
        correctCard = atm.start()
        if (correctCard > 0) continue
        println("Продолжить нажмите Enter. Для выхода нажимите q:")
        when(readLine()) {
            "q" -> exitProcess(1)
            else -> {
                count--
                if (count == 0) {
                    println("Потрачено количество попыток! До свидания!")
                    exitProcess(2)
                }
                println("Продолжаем попытки, осталось $count попыток")
            }
        }
    }

    while (true) {
        when (atm.accountRecord()) {
            1 -> balanceCard = mainAccount(balanceCard,"карт") //карта
            2 -> balanceBook = mainAccount(balanceBook,"сбер.книжки") //сбер книжка
            3 -> exitProcess(3)
            else -> exitProcess(3)
        }
        println("q - Выход. Enter - продолжим.")
        when (readLine()) {
            "q" -> exitProcess(5)
            else -> println("Продолжим...")
        }
    }
    atm.stop()
}

fun main() {
    bankService()
}