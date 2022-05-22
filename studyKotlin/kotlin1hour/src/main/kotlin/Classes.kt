
//Primary Constructor - первичный конструктор
class Person(val firstName: String, val lastName: String, var age: Int ) {
    var children: MutableList<Person> = mutableListOf() //ArrayList

    init {
        println("Person is created $firstName")
    }
    //вторичный констуктор
    constructor(firstName: String, lastName: String, age: Int, child: Person) :
            this(firstName,lastName,age) { //должен обязательно наследовать первичный конструктор
        children.add(child)
    }
    //констуктор по умолчанию, без аргументов
    constructor(): this("","",-1)
}

data class Rectangle(var height: Double, var lenght: Double) {
    var perimeter = (height + lenght) * 2
    var test = 1
    get() = field + 1 //field как this.поле
    set(value) {
        if (value < 0) println("Negative value")
        field = value
    }
    //функция подсчета площади прямоугольника
    fun area() = height * lenght
}

fun main() {
    val child = Person("Child","SmallChild",1)
    val p1 = Person("Tom","Hardy",35,child)
    println(p1.firstName)

    val rectangle1 = Rectangle(5.0,2.3)
    println("The perimeter is ${rectangle1.perimeter}")

    val rectangle2 = Rectangle(5.0,2.3)
    println(rectangle1 == rectangle2) //переопределенный метод equals() должен сравнить два объекта по полям (из-за data)
}