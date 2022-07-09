@file:JvmName("Main")

import com.motoralex73.sudosolver.CheckOutcome
import com.motoralex73.sudosolver.Coordinate
import java.io.File

fun main() {
    val input = readFile("input")
    val solution = readFile("solution")

    var result = CheckOutcome.Ok
    for (i in 0 until 9) {
        val checkOutcome = checkLine(i,input,solution)
        if (checkOutcome != CheckOutcome.Ok) {
            result = checkOutcome
            break
        }
    }
    println(result)
}

fun readFile(filename:String): Map<Coordinate,Int> =
    File(filename)
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val xCoordinate = indexedValue.index
            indexedValue.value.toCharArray().withIndex()
                .filter { indexedChar -> indexedChar.value != '.' }
                .map { indexedChar ->
                    val yCoordinate = indexedChar.index
                    val coordinate = Coordinate(x=xCoordinate, y=yCoordinate)
                    val number = Character.getNumericValue(indexedChar.value)
                    coordinate to number
                }
        }
        .toMap()



fun checkLine(lineNumber: Int, input: Map<Coordinate,Int>, solution: Map<Coordinate, Int>) : CheckOutcome {
    for (i in 0 until 8) {
        val checkCoordinate = Coordinate(x=lineNumber, y=i)
        val checkValue = input[checkCoordinate] ?: solution[checkCoordinate] ?: return CheckOutcome.Incomplete
        for (j in 0 until 9) {
            val internalCoordinate = Coordinate(x = lineNumber, y = j)
            val internalValue = input[internalCoordinate] ?: solution[internalCoordinate] ?: return CheckOutcome.Incomplete
            if (checkValue != internalValue) {
                return CheckOutcome.Failed
            }
        }
    }
    return CheckOutcome.Ok
}