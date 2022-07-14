package com.motoralex73.sudosolver

typealias Generator = (Int) -> Coordinate

fun rowCordinateGenerator(rowNumber: Int): Generator = { index -> Coordinate(x = rowNumber, y = index ) }
fun colCordinateGenerator(colNumber: Int): Generator = { index -> Coordinate(x = index, y = colNumber) }
fun quadCordinateGenerator(quadNumber: Int): Generator = { index ->
    val x = 3 * (quadNumber / 3) + index / 3
    val y = 3 * (quadNumber % 3) + index % 3
    Coordinate(x, y)
}
