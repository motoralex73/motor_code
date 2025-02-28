package coffee_shops

class MoscowCoffeeShop(priceAmericano: Double, priceCappuccino: Double, priceLatte: Double) :
    CoffeeShop(priceAmericano, priceCappuccino, priceLatte), Biscuits {
    override fun makeAmericano() {
        countAmericano++
        println("Thanks for Americano in Moscow")
    }

    override fun makeCappuccino() {
        countCappuccino++
        println("Thanks for Cappuccino in Moscow")
    }

    override fun makeLatte() {
        countLatte++
        println("Thanks for Latte in Moscow")
    }

    override fun sellBiscuits() {
        println("Take your biscuits")
    }

}