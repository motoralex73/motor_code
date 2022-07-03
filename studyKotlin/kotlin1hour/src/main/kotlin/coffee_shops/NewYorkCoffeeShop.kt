package coffee_shops

class NewYorkCoffeeShop(priceAmericano: Double, priceCappuccino: Double, priceLatte: Double) :
    CoffeeShop(priceAmericano, priceCappuccino, priceLatte) {
    override fun makeAmericano() {
        countAmericano++
        println("Thanks for Americano in NewYork")
    }

    override fun makeCappuccino() {
        countCappuccino++
        println("Thanks for Cappuccino in NewYork")
    }

    override fun makeLatte() {
        countLatte++
        println("Thanks for Latte in NewYork")
    }

}