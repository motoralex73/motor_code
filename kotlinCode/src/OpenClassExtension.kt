open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("view show off")
fun Button.showOff() = println("button show off")

//пример свойства-расширения
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length-1, value)
    }

class User(val id: Int, val name: String, val address: String)
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalAccessException("Cannot save user $id: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    println("save user")
}

fun main() {

    val view: View = Button()
    view.click()
    view.showOff()

    var s = StringBuilder("Hello")
    println(s.lastChar)

    saveUser(User(11,"Vasya", "email@mail.ru"))
}
