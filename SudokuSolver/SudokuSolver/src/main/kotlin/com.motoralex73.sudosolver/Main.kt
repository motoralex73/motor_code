@file:JvmName("Main")

package com.motoralex73.sudosolver
import java.io.File

fun main() {
    val input = readFile("input")
    val solution = readFile("solution")

    val result = validateGame(input, solution)

    println(result)
}

fun readFile(filename:String): GameBoard =
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

fun String.asGameBoard(): GameBoard =
    this.lines()
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


