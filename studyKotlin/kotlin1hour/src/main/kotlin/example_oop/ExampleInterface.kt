interface ExampleInterface {
    val sayHello: String;
    fun showHello() = sayHello
}

interface DbConnection {
    fun getConnection(): String
}