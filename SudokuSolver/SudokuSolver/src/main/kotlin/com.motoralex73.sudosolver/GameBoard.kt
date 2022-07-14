package com.motoralex73.sudosolver

typealias GameBoard = Map<Coordinate,Int>


fun validateSimilar(input: GameBoard, solution: GameBoard, coordinateGenerator: Generator) : CheckOutcome {
    for (i in 0 until 8) {
        val checkCoordinate = coordinateGenerator(i)
        val checkValue = input[checkCoordinate] ?: solution[checkCoordinate] ?: return CheckOutcome.Incomplete
        for (j in 0 until 9) {
            val internalCoordinate = coordinateGenerator(j)
            val internalValue = input[internalCoordinate] ?: solution[internalCoordinate] ?: return CheckOutcome.Incomplete
            if (checkValue != internalValue) {
                return CheckOutcome.Failed
            }
        }
    }
    return CheckOutcome.Ok
}

fun validateGame(input: GameBoard, solution: GameBoard): CheckOutcome {

    var result = CheckOutcome.Ok
    for (i in 0 until 9) {
        val rowCheckOutcome =
            validateSimilar(input,solution, rowCordinateGenerator(rowNumber = i))
        if (rowCheckOutcome != CheckOutcome.Ok) {
            result = rowCheckOutcome
            break
        }
        val columnCheckOutcome =
            validateSimilar(input, solution, colCordinateGenerator(colNumber = i))
        if (columnCheckOutcome != CheckOutcome.Ok) {
            result = columnCheckOutcome
            break
        }
        val quadrantCheckOutcome = validateSimilar(input,solution, quadCordinateGenerator(quadNumber = i))
        if (quadrantCheckOutcome != CheckOutcome.Ok) {
            result = quadrantCheckOutcome
            break
        }
    }
    return result
}