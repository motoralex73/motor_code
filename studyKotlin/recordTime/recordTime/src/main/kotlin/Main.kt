import java.sql.Time
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

const val fileName = "workTime.dat"

fun setTime() {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formatted = current.format(formatter)

    print("Введите час прихода: ")
    var h1:Int = readLine()!!.toInt()
    print("Введите минуты прихода: ")
    var m1:Int = readLine()!!.toInt()

    print("Введите час ухода: ")
    val h2:Int = readLine()!!.toInt()
    print("Введите минуты ухода: ")
    val m2:Int = readLine()!!.toInt()

    if (m1 > 59) m1 = 0
    if (h1 < 8 || h1 > 19) {
        h1 = 8
        m1 = 0
    }
    var h3 = h2 - h1
    if (h3 < 0) println("Введено некорректное время прибытия")
    h3 -= 8

    var m3 = m2 - m1
    if (m3 >= 30) m3 -= 30
    else {
        m3 += 30
        h3 -= 1
    }

    var resHour = 0
    var resMin = 0
    resHour += h3
    resMin += m3

    val setNewRecordToFile = RecordTime(formatted, Time(h1,m1,0),Time(h2,m2,0), Time(h3,m3,0),fileName)
    setNewRecordToFile.saveCurrentTimeToFile()
}

fun main() {
    while (true) {
        println("Программа учета отработанного времени!")
        println(
            "Выберите действие:\n" +
                    "1 - Добавить запись\n" +
                    "2 - Удалить запись\n" +
                    "3 - Просмотреть журнал записей\n" +
                    "4 - Выход\n"
        )

        val getRecordFromFile = GetRecordFromFile(fileName)

        when (readLine()) {
            "1" -> setTime()
            "2" -> println("hello delete")
            "3" -> getRecordFromFile.getAllTimeFromFile()
            else -> exitProcess(1)
        }
    }
}