package little_programs

    fun getResult(first: Double, second: Double, operator: String): Double {
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "/" -> first / second
            "*" -> first * second
            else -> 0.0
        }
    }

    fun main() {
        while (true) {
            println("Enter number:")
            val first = readln().toDoubleOrNull()
            println("Enter number:")
            val second = readln().toDoubleOrNull()
            println("Enter operator:")
            val operator = readln()

            if (first == null || second == null || operator.isEmpty())
                println("Enter valid data")
            else {
                val result = getResult(first, second, operator)
                println("Result=$result")
            }
        }
    }
