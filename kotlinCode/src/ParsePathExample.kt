fun main() {
    val path = "/usr/lib/home/data.ept"
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("dir: $directory, fullname: $fullName, filename: $fileName, extension: $extension")
}