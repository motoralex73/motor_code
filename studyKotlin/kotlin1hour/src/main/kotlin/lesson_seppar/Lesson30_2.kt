package lessons

fun main() {
    val cities: ArrayList<String> =
        arrayListOf("Moscow", "Samara", "NewYork", "LosAngeles", "Samara")

    print("All cities: ")
    println(cities)
    print("Города с названием > 6 символов: ")
    println(cities.filter { e -> e.length > 6 })
    print("Введите вой город: ")
    val pcity = readLine()
    println("$pcity встречается:  ${cities.count { e -> pcity.equals(e) }} ")
    print("Введете букву: ")
    val b = readLine()
    if (b?.length == 1) {
        println(cities.filter { e -> b == e[0].toString() })
    }

}