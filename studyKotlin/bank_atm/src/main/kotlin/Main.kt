import kotlin.system.exitProcess

fun main() {
    val atm = Atm()
    var correctCard = false
    var count = 3

    do {
        correctCard = atm.start()
        println("Продолжить нажимите Enter. Для выхода нажимите q:")
        when(readLine()) {
            "q" -> exitProcess(1)
            else -> {
                count--
                if (count == 0) exitProcess(2)
                println("Продолжаем попытки, осталось $count попыток")
            }
        }
    }
    while (!correctCard)

    atm.stop()
}