fun <T> joinToString(collection: Collection<T>,
                     separator: String = "; ",
                     prefix: String = "",
                     postfix: String = ""
         ): String
{
    val result = StringBuilder(prefix)
    for ((ind, el) in collection.withIndex())
    {
        if (ind > 0) result.append(separator)
        result.append(el)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {

    val list = listOf(1,2,3)
    println(joinToString(list))
}