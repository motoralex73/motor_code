import coffee_shops.Biscuits
import coffee_shops.CoffeeShop
import coffee_shops.MoscowCoffeeShop
import coffee_shops.NewYorkCoffeeShop
import kotlin.system.exitProcess

fun main() {
    val moscowCoffeeShop = MoscowCoffeeShop(3.0, 4.5, 5.0)
    val newYorkCoffeeShop = NewYorkCoffeeShop(4.0, 7.5, 8.0)
    var currentCoffeeShop: CoffeeShop

    while (true) {
        println("Hello. Choose a city:")
        println("1. Moscow\n2. New York\n3. 0 - exit")

        currentCoffeeShop = when (readLine()) {
            "1" -> moscowCoffeeShop
            "2" -> newYorkCoffeeShop
            "0" -> break
            else -> {
                println("Error")
                continue
            }
        }

        chooseDrink(currentCoffeeShop)
    }
}

private fun chooseDrink(currentCoffeeShop: CoffeeShop) {
    println("Choose a drink:")
    println("1. Americano\n2. Cappuccino\n3. Latte\n\n0. Show statics")

    when (readLine()) {
        "1" -> {
            currentCoffeeShop.makeAmericano()
            checkAndAskBiscuits(currentCoffeeShop)
        }

        "2" -> {
            currentCoffeeShop.makeCappuccino()
            checkAndAskBiscuits(currentCoffeeShop)
        }

        "3" -> {
            currentCoffeeShop.makeLatte()
            checkAndAskBiscuits(currentCoffeeShop)
        }

        "0" -> currentCoffeeShop.showStatics()
        else -> {
            println("Error")
            exitProcess(1)
        }
    }
}

private fun checkAndAskBiscuits(currentCoffeeShop: CoffeeShop) {
    if (currentCoffeeShop is Biscuits) { //если есть имплементация интерфейса
        println("Would you like biscuits?")
        println("1. Yes\n2. No")
        when (readLine()) {
            "1" -> currentCoffeeShop.sellBiscuits()
        }
    }
}