package motor73_autoservice

data class SimpleCar(
    override val number: String,
    override val year: Int,
    override val color: String,
    override val powerEngine: Double,
    override val typeAkpp: Type_akpp,
    override val haveAllRoad: Type_allRoad
) : Car {

    override fun toString(): String {
        return "Г/н: $number выпуск: $year год, цвет: $color, мощность: $powerEngine л.с., тип коробки: $typeAkpp, привод: $haveAllRoad "
    }

    fun showCarParameters() {
        println(this.toString())
    }
}
