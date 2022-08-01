import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.nio.charset.Charset
import java.sql.Time
import java.util.Date

class RecordTime(private val date:String, private val timeStart:Time, private val timeEnd:Time,
                 private val timeReserve:Time, fileName: String) {
    private val f = File(fileName)

    private fun countMatches(string: String, pattern: String): Int {
        return string.split(pattern)
            .dropLastWhile { it.isEmpty() }
            .toTypedArray().size - 1
    }

    private fun getList(string:String): List<String> {
        var l:MutableList<String> = mutableListOf()
        val file = File("workTime.dat")
        try {
            BufferedReader(FileReader(file)).use { br ->
                var line: String?
                while (br.readLine().also {
                        line = it
                        l.add(line.toString())
                } != null) {
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return l
    }

    private fun getHour(string: String): Int {

        val result1 = string.drop(65)
        val result2 = result1.dropLast(7)

        val h = result2.toInt()
        println("RESULT1=$result1")
        println("RESULT2=$result2")
        return h
    }


    private fun getMin(string: String): Int {

        val result1 = string.drop(72)
        val m = result1.toInt()
        println("RESULT1=$result1")
        return m
    }

    fun saveCurrentTimeToFile() {
        val fileRead = f.readText()
        val count = 0//countMatches(fileRead,date)
        val listFile = getList(fileRead)
        val lastString = listFile[listFile.count()-2]
        listFile.forEach {
            println(it)
        }
        println("LAST STRING=$lastString")

        val h = getHour(lastString)
        println("H=$h")

        val m = getMin(lastString)
        println("M=$m")

        val resMin = 10
        if (count == 0) {
            val timeString = "$date > $timeStart - $timeEnd = $timeReserve |> запас времени час=${11} мин=${12}\n"
            println("Добавлена новая запись: $timeString")
            f.appendText(timeString, charset = Charset.defaultCharset())
        }
        else
        {
            println("Запись с такой датой уже существует!")
        }
    }

}

