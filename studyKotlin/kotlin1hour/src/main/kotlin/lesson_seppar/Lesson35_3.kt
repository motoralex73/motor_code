class Sum<T> (var x: T, var y: T, var z: T)

fun main() {
    val lamda = {x:Int,y:Int,z:Int ->
        x+y+z
   }

    val a = lamda(5,6,7)
    println(a)

    var b = 10
    val lam2 = {b++}
    println(b)
    lam2()
    println(b)


    val lamdaSum = {xx:Sum<Int> ->
        val list = arrayListOf(xx.x,xx.y,xx.z)
        //list.sort()
        println(list)
        println("max="+ list.maxByOrNull { it -> it } )
        println("min="+ list.minByOrNull { it -> it } )
        //println("min="+list.first())
        //println("max="+list.last())
    }

    val s = Sum(11,2,3)
    lamdaSum(s)



}