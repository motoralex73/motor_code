package motor73_autoservice

fun main() {
    val car1 = SimpleCar("a555bb77", 1999, "Red", 132.3, Type_akpp.MANUAL, Type_allRoad.P4x4)
    car1.showCarParameters()
    val client1: SimpleClient = SimpleClient("Vasya", "Rogov", "+79231212355", "Check engine")
    client1.showClient()
}