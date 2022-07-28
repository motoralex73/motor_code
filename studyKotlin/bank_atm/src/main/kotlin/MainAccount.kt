class MainAccount(private val balance:Double) {
//баланс счета для всех карт общий
    fun printBalance() {
        println("Баланс счета Ваших карт составляет: $balance")
    }
}