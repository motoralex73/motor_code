package little_programs


fun main() {
    println("Enter names people:")
    val names = readln().orEmpty()
    val namesArray = names.split(",")
    //println(namesArray)
    println("Enter selaries:")
    val selaries = readln().orEmpty()
    val selariesArray = selaries.split(",")

    validLength(namesArray, 10, "Name")
    validLength(selariesArray, 6, "Salary")

    printTable(namesArray, selariesArray)

}

fun printTable(namesArray: List<String>, selariesArray: List<String>) {
    println("-".repeat(23))

    for (name in namesArray) {
        val index = namesArray.indexOf(name)
        val salary = selariesArray[index]
        val f1 = (12 - name.length) / 2
        val f2 = 12 - name.length - f1
        val s1 = (8 - salary.length) / 2
        val s2 = 8 - salary.length - s1

        print("|" + " ".repeat(f1) + name + " ".repeat(f2) + "|" + " ".repeat(s1) + salary + " ".repeat(s2) + "|\n")
    }
    println("-".repeat(23))

}

fun validLength(namesArray: List<String>, maxSize: Int, entity: String) {
    for (i in namesArray) {
        if (i.length > maxSize) println("$entity must be up to $maxSize characters")
        break
    }

}
