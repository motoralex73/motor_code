package lessons

class Car(val name: String, val year: Int, val price: Double, val color: String, val ob: Double) {
    override fun toString(): String {
        return "$name $color $ob $price $year"
    }
}

fun main() {
    val c1: ArrayList<Car> = arrayListOf(
        Car("Porsche", 1999, 123000.0, "red", 4.5),
        Car("Porsche", 2020, 500000.0, "white", 12.6),
        Car("Lada", 2010, 50000.0, "green", 1.5),
        Car("Honda", 1988, 1000.0, "white", 1.4)
    )

    for (i in c1.stream()) println(i)
    println(c1.sortedWith(compareBy { it.price }))

//    println( c1.filter { e -> e.color == "white" } )
//    println( c1.filter { r -> r.ob == 1.5 } )
//    println( c1.filter { e -> e.price > 1000.0 } )
//    println( c1.filter { e -> (e.year in 1989..2019) } )

    //println( c1.sortBy { e -> e.price } )


}