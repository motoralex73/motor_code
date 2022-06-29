
sealed class Db{
    data class MySQL(val id:Int, val conn:String) : Db()
    data class MongoDB(val id:Int, val conn:String) : Db()
    data class PostgreSQL(val id:Int, val conn:String, val isDone:Boolean) : Db()
    object Help : Db() {
        val conn = "Connection done!"
    }

}

//привязка функции к изолированному классу Db.MongoDB
fun Db.MongoDB.printInfo() {
    println("MongoDB has id: $id and connection: $conn")
}

val Db.MongoDB.info: String get() = "Hello var info"

//фунция принимающая список строк и др функцию, которая возвращает булеан-значение
fun filterList(list: List<String>, filter: (String) -> Boolean) {
    list.forEach { el ->
        if (filter(el))
            println(el)
    }
}

val filter: (String) -> Boolean = {
    it.startsWith("P")
}

fun main() {
    val db = Db.MongoDB(5,"mongo")
    val db_2 = Db.PostgreSQL(5,"mongo",true)
    val db_copy = db.copy()
    if (db == db_copy) println("они равны")
    val db_copy_2 = db.copy(conn = "Done")
    db.printInfo()
    println(db.info)

    val list = listOf("Java", "PHP", "Perl", "C++", "JavaScript")
    filterList(list, filter) //вызов функции
}