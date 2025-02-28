
fun someThreads() {
    val threads = mutableListOf<Thread>()
    for (i in 1..10) {
        val t = Thread {
            while (true) {
                println("Поток $i запущен")
                Thread.sleep(1000)
                println("Поток $i завершен")
            }

        }
        threads.add(t)
        t.start()
    }
    for (t in threads) {
        t.join()
    }
    println("Все потоки завершены")
}


fun main() {
    someThreads()
}