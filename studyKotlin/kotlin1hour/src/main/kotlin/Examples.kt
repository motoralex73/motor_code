//функция сравнения двух массивов и вывод значений имеющих пересечение, с количеством пересечений
// [1,2,3,3,4,2] и [1,3,4,5,2,3]
// вывод [1,2,3,3,4]
fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {
    val s1 = a1.toHashSet()
    val s2 = a2.toHashSet()

    val result = mutableListOf<Int>()

    for (el in s1) {
        if (s2.contains(el)) {
            val numOfRepeats = minOf(a1.count { it == el }, a2.count { it == el })
            repeat(numOfRepeats) { result.add(el) }
        }
    }
    return result
}

//функция подсчета вхождения символов
//AAAAAAAABBBBBBBBBCCDXXXX -> A8B9C2DX4
fun countLetters(str: String): String {
    var currentLetter = str[0]
    var count = 1
    var result = ""

    for (letter in str.substring(1)) {
        if (currentLetter == letter) {
            count++
        }
        else {
            if (count == 1) result += currentLetter
            else result += "$currentLetter$count"

            count = 1
            currentLetter = letter
        }
    }

    //обрабатываем последние буквы в строке
    if (count == 1) result += currentLetter
    else result += "$currentLetter$count"

    return result
}

//функция группирования массивов слов по совпадению в них символов
// ["tan","ate","eat","tea","nat","bat"]
// результат: [[tan, nat], [ate, eat, tea], [bat]]
fun groupWords(words: Array<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()
    val map = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)
    }

    for ((key,value) in map)
        result.add(value)

    return result
}

fun main() {
    println( getRepeatedIntersection(intArrayOf(1,2,3,3,4,2), intArrayOf(1,3,4,5,2,3)) )
    println( countLetters("AAAAAAAABBBBBBBBBCCDXXXX") )
    println( groupWords(arrayOf("tan","ate","eat","tea","nat","bat")) )
}