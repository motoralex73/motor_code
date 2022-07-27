package lesson_seppar
//1.
//interface User {
//    val nickname: String
//}
//
//class PrivateUser(override val nickname: String): User
//
//class SubscribingUser(val email: String): User {
//    override val nickname: String
//        get() = email.substringBefore('@')
//}
//
//class FacebookUser(val accountId: Int): User {
//    override val nickname: String
//        get() = getFacebookName(accountId)
//}


//2.
//class User private constructor(val nickname: String) {
//    companion object {
//        fun newSubscribingUser(email: String) =
//            User(email.substringBefore('@'))
//        fun newFacebookUser(accountId: Int) =
//            User(getFacebookName(accountId))
//    }
//}

fun main() {

}