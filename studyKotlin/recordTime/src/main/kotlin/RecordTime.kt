import java.io.File
import java.nio.charset.Charset
import java.sql.Time
import java.util.Date

class RecordTime(private val date:String, private val timeStart:Time, private val timeEnd:Time, private val timeReserve:Time) {
    private val f = File("workTime.dat")

    private fun countMatches(string: String, pattern: String): Int {
        return string.split(pattern)
            .dropLastWhile { it.isEmpty() }
            .toTypedArray().size - 1
    }

    fun saveCurrentTimeToFile() {
        val fileRead = f.readText()
        val count = countMatches(fileRead,date)
        println(count)
        if (count == 0) {
            val timeString = "$date > $timeStart - $timeEnd = $timeReserve\n"
            println("Добавлена новая запись: $timeString")
            f.appendText(timeString, charset = Charset.defaultCharset())
        }
        else
        {
            println("Запись с такой датой уже существует!")
        }
    }

    fun getAllTimeFromFile() {}
    fun correctFile() {}
}

