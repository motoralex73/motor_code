interface ExampleInterface {
    val sayHello: String;
    fun showHello() : String{
        return sayHello
    }
}

interface DbConnection {
    fun getConnection() : String
}