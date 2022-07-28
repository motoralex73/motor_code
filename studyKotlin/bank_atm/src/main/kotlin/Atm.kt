class Atm {
    private val card = listOf(
        Card(1234567890,4357),
        Card(2143658709,3322))
    private var num = 0
    private var pin = 0

    fun start(): Int {
        println("Добро пожаловать в главное меню банкомата!")
        println("Введите номер карты: ")
        num = readLine()!!.toInt()
        println("Введите пин-код: ")
        pin = readLine()!!.toInt()

        card.forEach {
          if (it.numberCard == num && it.pinCode == pin) {
              println("Всё верно, продолжаем.")
              return num
          }
          println(it)
        }
            println("Ошибка, неправильный номер или пин-код карты")
            return 0
    }

    fun stop() {
        println("Мы завершаем обслуживание. До новых встреч!")
    }

    fun accountRecord(): Int {
        println("Выберите учетную запись для доступа:\n" +
                "1 - Карты банка\n" +
                "2 - Сбер книжка\n" +
                "3 - Выход")
        return when(readLine()!!.toInt()) {
            1 -> 1
            2 -> 2
            3 -> 3
            else -> 3
        }
        return 3
    }
}