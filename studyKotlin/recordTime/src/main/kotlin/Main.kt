import java.sql.Time
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun setTime() {
    println("Программа учета отработанного времени!")
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val formatted = current.format(formatter)

    print("Введите час прихода: ")
    val h1:Int = readLine()!!.toInt()
    print("Введите минуты прихода: ")
    val m1:Int = readLine()!!.toInt()

    print("Введите час ухода: ")
    val h2:Int = readLine()!!.toInt()
    print("Введите минуты ухода: ")
    val m2:Int = readLine()!!.toInt()

    var h3 = h2 - h1 - 8
    if (h3 < 0) println("Введено некорректное время прибытия")

    var m3 = m2 - m1
    if (m3 >= 30) m3 -= 30
    else {
        m3 += 30
        h3 -= 1
    }

    val rec = RecordTime(formatted, Time(h1,m1,0),Time(h2,m2,0), Time(h3,m3,0))
    rec.saveCurrentTimeToFile()
}

fun main() {
    setTime()
}