package motor73_autoservice

class SimpleClient(
    override val firstName: String,
    override val lastName: String,
    override val telNumber: String,
    override val whatMake: String
) : Client {

    override fun toString(): String {
        return "$firstName $lastName $telNumber : $whatMake"
    }

    fun showClient() {
        println(this.toString())
    }
}