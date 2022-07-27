class Atm {
    val card = Card(1234567890,4357)
    private var num = 0
    private var pin = 0

    fun start(): Boolean {
        println("Добро пожаловать в главное меню банкомата!")
        println("Введите номер карты: ")
        num = readLine()!!.toInt()
        println("Введите пин-код: ")
        pin = readLine()!!.toInt()

        if (num == card.numberCard && pin == card.pinCode) {
            println("Всё верно, продолжаем.")
            return true
        }
        else {
            println("Ошибка, неправильный номер или пин-код карты")
            return false
        }

    }
    fun stop() {
        println("Мы заершаем обслуживание. До новых встреч!")
    }
}