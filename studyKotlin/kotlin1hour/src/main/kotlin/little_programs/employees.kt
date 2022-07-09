package little_programs

enum class WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    fun isWeekend(): Boolean = when(this) {
        SATURDAY, SUNDAY -> true
        else -> false
    }
}

enum class AtWorkState {
    AT_WORK,
    WEEKEND,
    ILLNESS
}



fun main() {
    val employees = listOf(
        Person("John","Doe"),
        Person("Bill","Deebeel"),
        Person("Michael","Jordan"),
        Person("Ivan","the Terrible", isIll = true)
    )

//    employees.forEach { person ->
//        println("$person is at work: ${shouldBeAtWork(person, WeekDays.THURSDAY)}")
//    }

    WeekDays.values()
        .forEach { day ->
            println("-------------------")
            println("$day has started")
            employees.forEach { person ->
                when(shouldBeAtWork(person,day)) {
                    AtWorkState.AT_WORK -> println("$person is at work")
                    AtWorkState.WEEKEND -> println("$person is having a day off")
                    AtWorkState.ILLNESS -> println("$person is illness")
                }
            println("$person is at work: ${shouldBeAtWork(person, day)}")
            }
        }
}

fun shouldBeAtWork(person: Person,day: WeekDays): AtWorkState = when {
    person.isIll ->AtWorkState.ILLNESS
    day.isWeekend() -> AtWorkState.WEEKEND
    else -> AtWorkState.AT_WORK
}

