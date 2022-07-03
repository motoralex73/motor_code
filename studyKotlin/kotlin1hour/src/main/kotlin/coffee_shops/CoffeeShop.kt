package coffee_shops

abstract class CoffeeShop(val priceAmericano: Double, val priceCappuccino: Double, val priceLatte: Double) {
    var countAmericano = 0
    var countCappuccino = 0
    var countLatte = 0

    abstract fun makeAmericano()
    abstract fun makeCappuccino()
    abstract fun makeLatte()

    fun showStatics() {
        println("Americano sold: $countAmericano")
        println("Cappuccino sold: $countCappuccino")
        println("Latte sold: $countLatte")

        val money = countAmericano * priceAmericano +
                    countCappuccino * priceCappuccino +
                    countLatte * priceLatte

        println("All money is: $money")
    }
}