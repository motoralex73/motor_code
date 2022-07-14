package lesson_seppar

import java.math.BigInteger

fun main() {
    val x = 9
    val y = 7

    val myMax = { x1:Int, y1:Int ->
        println("x=$x y=$y")
        if (x1>y1) println("x>y") else println("y>x")
    }

    val myMin = { x1:Int,y1:Int ->
        if (x1<y1) x1
        else y1
    }

    val myFact = {x1:Int ->
        var p = 1
        if (x1 > 0) for (i in 1..x1) {
            p *= i
        }
        println("factorial $x1 = $p")
    }

    val mySimple = { x1:Long ->
        val b:BigInteger = BigInteger.valueOf(x1)
        val p:Boolean = b.isProbablePrime(x1.toInt())
        println("x=$x1 simple is $p")
    }

    myMax(x,y)

    println("x=$x y=$y, min = "+myMin(x,y))

    myFact(x)

    mySimple(x.toLong())


}