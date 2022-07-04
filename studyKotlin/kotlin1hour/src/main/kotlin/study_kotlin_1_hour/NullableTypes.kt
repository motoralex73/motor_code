fun main() {
    var a : String = "Hello"
    //a = null // NULL Pointer Exception полностью исключены
    var b : String? = "Test" //тип с проверкой save call
    b = null
    b?.length // save call, ? - проверяет что вернуть, чтобы исключить NPE, просто вернется null

    //Elvis оператор - ?:
    val l = b?.length ?: -1 //если b - не null, то в l положится длина, если null, то -1

    // !! - выбрасывает NPE, если в переменной null
    b = if ((0..10).random() > 5) "asd" else null
    val t = b!!.length
    println(t)
}