import java.io.File

class GetRecordFromFile(fileName: String) {

    fun getAllTimeFromFile() {
        val f = File(fileName)
        val fileRead = f.readText()
        println(fileRead)
    }
    fun correctFile() {}
}