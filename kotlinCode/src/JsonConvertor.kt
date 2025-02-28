import java.io.File
import java.text.Normalizer
import javax.swing.JFrame as JFrame

class JsonConvertor {
}



fun xz(s : String) : Any {
    return when(s) {
        "Red" -> 0
        "Green" -> 1
        "Orange" -> "wait"
        else -> "xz"
    }
}

fun main() {

//    val cv = JFrame()
//    cv.setLocation(100,100)
//    cv.setSize(1200,600)
//    cv.show()

    val v = ViewWindow()
    v.panel1.setLocation(100,100)
    v.panel1.setSize(1000,500)
    v.panel1.show()

    println(xz("Orange"))

    val list = listOf(1,2,3,4,5,11,0)
    val pos = list.filter { it < 10 }
    println(pos)



}

