import kotlin.collections.ArrayList
// yandex task 1
fun twoMassive() {
    val arr1 = hashSetOf(1, 2, 3, 2, 0)
    val arr2 = hashSetOf(1, 2, 2, 3)
    val res = mutableListOf<Int>()

    for (i in arr1) {
        if (arr2.contains(i)) {
            val numOfRepeat = minOf(arr1.count { it == i }, arr2.count { it == i })
            repeat(numOfRepeat) { res.add(i) }
        }
    }
    println(res)
}

// yandex task 2
fun parseStringLetter() {
    val str = "AAAAACCCDDFFFMMMRRRRR"
    println(parse(str))
}

fun parse(str: String): String {
    var result = ""
    var ch = str[0]
    var count = 1
    for (letter in str.substring(1)) {
        if (ch == letter) {
            count++
        }
        else {
            if (count == 1) result += ch
            else result += "$ch$count"
            count = 1
            ch = letter
        }
    }

    if (count == 1) result += ch
    else result += "$ch$count"

    return result
}

// yandex task 3
fun groupWords(words: Array<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()
    val map = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedWord)) map[sortedWord]?.add(word)
        else map[sortedWord] = mutableListOf(word)
    }

    for ((key, value) in map) result.add(value)

    return result
}

fun main() {
    //twoMassive()
    parseStringLetter()
    //println( groupWords(arrayOf("eat", "tea", "tan", "ate", "nat", "bat", "tab")) )
}

