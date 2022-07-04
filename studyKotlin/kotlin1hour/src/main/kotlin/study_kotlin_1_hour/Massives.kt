
fun main() {

    var m_array: Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9)
    var m_list: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9)
    var m_map = mutableMapOf("key1" to 1, "key2" to "simple key")

    m_array.set(4,12)
    m_list.add(4,55)
    m_list.addAll(listOf(4,5,6,7))
    m_map.put("city","New York")

    for (i in m_array) print("$i ")
    println()
    for (i in m_list) print("$i ")
    println()
    println(m_map)

}