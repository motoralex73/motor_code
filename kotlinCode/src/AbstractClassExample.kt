// interfaces
interface Clickable {
    fun click()
    fun showOff() = println("Im clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("Im focusable!")
    fun func() {}
}

class InterfaceExample : Clickable, Focusable {
    override fun click() = println("Im was clickable button!")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

// abstraction
abstract class AbsClass: Clickable {
    abstract fun absFunc()
    open fun openFunc() {}
    fun closeFunc() {
        println("call inside AbsClass")
    }
}

abstract class AbsClass2 {
    open fun absFunc1() {}
    open fun openFunc1() {}
}

class ChildAbsCLass : AbsClass() {
    override fun absFunc() {
        println("call absFunc")
    }
    override fun openFunc() {
        println("call openFunc")
    }

    override fun click() {
        println("click child class")
    }
}

fun main() {
//    val button = InterfaceExample()
//    button.showOff()
//    button.setFocus(true)
//    button.click()

    val abs = ChildAbsCLass()
    abs.absFunc()
    abs.openFunc()
    abs.closeFunc()
    abs.click()
}
