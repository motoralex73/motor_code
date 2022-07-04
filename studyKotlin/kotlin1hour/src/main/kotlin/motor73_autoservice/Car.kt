package motor73_autoservice

enum class Type_akpp {
    AUTOMAT, MANUAL, ROBOT, DSG
}

enum class Type_allRoad {
    P4x4, P4x2
}

interface Car {
    val number: String
    val year: Int
    val color: String
    val powerEngine: Double
    val typeAkpp: Type_akpp
    val haveAllRoad: Type_allRoad
}