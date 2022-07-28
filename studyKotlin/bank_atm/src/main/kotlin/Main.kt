import kotlin.system.exitProcess

fun printAccount(str:String) {
    println("Меню $str:\n" +
            "1 - Просмотр баланса\n" +
            "2 - Снять средства\n" +
            "3 - Пополнить средства\n" +
            "4 - Выход")
}

fun mainAccount() {
    printAccount("основного счета по всем картам")
}

fun safeAccount() {
    printAccount("сберегательного счета книжки")
}

fun main() {
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

    var cardAccount = MainAccount(balanceCard)
    var bookAccount = SafeAccount(balanceBook)

    var deleteMoneyCard = 0.0
    var deleteMoneyBook = 0.0

    var addMoneyCard = 0.0
    var addMoneyBook = 0.0

    while (true) {
        when (atm.accountRecord()) {
            1 -> {
                mainAccount() //карта
                when (readLine()!!.toInt()) {
                    1 -> {
                        //cardAccount.printBalance()
                        println("Баланс карт: $balanceCard")
                    }
                    2 -> {
                        println(
                            "Текущий баланс карты: $balanceCard рублей\n" +
                                    "Укажите сколько средств снять:"
                        )
                        deleteMoneyCard = readLine()!!.toDouble()
                        balanceCard -= deleteMoneyCard
                        println("Баланс карты: $balanceCard")
                    }

                    3 -> {
                        println(
                            "Текущий баланс карты: $balanceCard рублей\n" +
                                    "Укажите сколько средств добавить:"
                        )
                        addMoneyCard = readLine()!!.toDouble()
                        balanceCard += addMoneyCard
                        println("Баланс карты: $balanceCard")
                    }

                    4 -> exitProcess(4)
                    else -> exitProcess(4)
                }
            }

            2 -> {
                safeAccount() //сбер книжка
                when (readLine()!!.toInt()) {
                    1 -> {
                        println("Баланс сбер книжки: $balanceBook")
                    //bookAccount.printBalance()
                    }
                    2 -> {
                        println(
                            "Текущий баланс книжки: $balanceBook рублей\n" +
                                    "Укажите сколько средств снять:"
                        )
                        deleteMoneyBook = readLine()!!.toDouble()
                        balanceBook -= deleteMoneyBook
                        println("Баланс карты: $balanceBook")
                    }

                    3 -> {
                        println(
                            "Текущий баланс книжки: $balanceBook рублей\n" +
                                    "Укажите сколько средств добавить:"
                        )
                        addMoneyBook = readLine()!!.toDouble()
                        balanceBook += addMoneyBook
                        println("Баланс сбер книжки: $balanceBook")
                    }

                    4 -> exitProcess(4)
                    else -> exitProcess(4)
                }
            }

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