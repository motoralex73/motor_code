import java.util.*
import kotlin.collections.HashMap

fun main() {
//prior - name
    var userMapPrior: HashMap<Int,String> = hashMapOf()
    var qReq: Queue<String> = PriorityQueue()

    while (true) {
        print("Приоритет: ")
        var prior: String = readLine().toString()
        if (prior == "exit") break
        print("Имя: ")
        var user: String = readLine().toString()

        userMapPrior[prior.toInt()] = user
    }

    userMapPrior.toSortedMap()
    //println(userMapPrior)

    var count:Int = 0
    for (i in userMapPrior) {
        count++
        println("[$count] -> $i")
        qReq.add(i.value)
    }
    println("Очередь по приоритетам: $qReq")









}