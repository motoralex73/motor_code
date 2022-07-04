import kotlin.collections.ArrayList

fun main() {
    var arr: ArrayList<Int> = ArrayList()
    arr.stream();
    run {
        var count = 25
        while (count > 0) {
            arr.add( (-1000..1000).random() )
            count--
        }
    }
    println(arr)

}