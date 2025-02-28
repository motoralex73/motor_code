
open class ClassExample {
    init {
        println("start init block 2")
    }
    init {
        println("init block: Start class example")
    }
    constructor() {
        println("0 const classExample")
    }
    constructor(i: Int) {
        println("1 arg, const i=$i")
    }
    constructor(i: Int, j: Int) {
        println("2 arg, const i=$i j=$j")
    }
}

open class MyClass: ClassExample {
    constructor(i: Int) : super(i)
    constructor()
}

class Opa: MyClass {
    private var aa: Int?
    get() = this.aa
    set(aa) {this.aa = aa}
    constructor() : super()
    constructor(i: Int): super(i)
    constructor(i: Int, j: Int): this(i) {
        println("i=$i j=$j")
    }
    interface User {
        val nickname: String
    }
    class PrivateUser(override val nickname: String) : User
    class SubscribingUser(val email: String) : User {
        override val nickname: String
            get() = email.substringBefore('@')
    }
    class FacebookUser(val accountId: Int) : User {
        override var nickname = "epta"
            set(value) {
                field = "Hello $value"
            }
        fun printValue() {
            println(nickname)
        }
    }
}

fun main() {

    //ClassExample()
    //MyClass(i = 777)
    Opa()
    Opa(i = 123, j = 345)
//    ClassExample(1,2)

//    val opa = Opa.FacebookUser(123)
//    opa.nickname = "nickname"
//    opa.printValue()
}

