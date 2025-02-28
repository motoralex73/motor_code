fun printHeader() {
    println("Выберите действие (q - выход):")
    println("1.Добавить нового пользователя")
    println("2.Удалить существующего пользователя")
    println("3.Проверить существует ли пользователь")
    println("4.Изменить логин существующего пользователя")
    println("5.Изменить пароль существующего пользователя")
}

fun main() {

    var mapUser: HashMap<String, String> = hashMapOf()

    while (true) {
        printHeader()
        when (readLine()) {
            "1" -> addUser(mapUser)
            "2" -> deleteUser(mapUser)
            "3" -> hasUser(mapUser)
            "4" -> renameLogin(mapUser)
            "5" -> renamePassword(mapUser)
            "q" -> break
        }
    }
}

fun renameLogin(mapUser: HashMap<String, String>) {
    print("Укажите пользователя для проверки наличия: ")
    val p = readLine().toString()
    for (i in mapUser) {
        if (i.key == p) {
            println("Есть такой пользователь ${i.key}:${i.value}")
            print("Укажите новый логин: ")
            val loginNew = readLine().toString()
            val passNew = mapUser.getValue(p).toString()
            mapUser.remove(p)
            mapUser[loginNew] = passNew
            println(mapUser)
            break
        }
    }
}

fun renamePassword(mapUser: HashMap<String, String>) {
    print("Укажите пароль для проверки наличия: ")
    val p = readLine().toString()
    for (i in mapUser) {
        if (i.value == p) {
            println("Есть такой пароль ${i.key}:${i.value}")
            print("Укажите новый пароль: ")
            val passNew = readLine().toString()
            val loginOld = i.key
            mapUser.remove(p)
            mapUser[loginOld] = passNew
            println(mapUser)
            break
        }
    }
}

fun hasUser(mapUser: HashMap<String, String>) {
    print("Укажите логин пользователя для проверки наличия: ")
    val p = readLine()
    for (i in mapUser) {
        if (i.key == p.toString()) {
            println("Есть такой пользователь ${i.key}:${i.value}")
            break
        }
    }
}

fun deleteUser(mapUser: HashMap<String, String>) {
    println(mapUser)
    print("Укажите логин пользователя для удаления: ")
    val p = readLine()
    for (i in mapUser) {
        if (i.key == p.toString()) {
            mapUser.remove(p.toString())
            break
        }
    }
    println(mapUser)
}

fun addUser(mapUser: HashMap<String, String>) {
    println("Укажите логин/пароль, для выхода login:q")
    while (true) {
        print("Login: ")
        var login: String = readLine().toString()
        if (login == "q") break
        print("Password:")
        var pass: String = readLine().toString()
        mapUser[login] = pass
    }
    println(mapUser)
}
