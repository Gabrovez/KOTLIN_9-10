package example

import kotlin.properties.Delegates

class UserProfile(initialName: String, initialEmail: String){
    var name: String by Delegates.observable(initialName) {_, old, new -> println("Name changed: $old -> $new") }
    var email: String by Delegates.observable(initialEmail) {_, old, new -> println("Email changed: $old -> $new") }
    val avatar: String by lazy {
        println("Загружаем аватар для $name...")
        "avatar_of_$name.png"
    }
}
fun main() {
    println("Creating user profile...")
    val user = UserProfile( "Alice",  "alice@example.com")

    println("\nName: ${user.name}")
    println("Email: ${user.email}")

    println("\nAccessing avatar for the first time:")
    println("Avatar file: ${user.avatar}")

    println("\nAccessing avatar again (should be taken from cache):")
    println("Avatar file: ${user.avatar}")

    println("\nChanging email:")
    user.email = "alice_new@example.org"

    println("\nChanging name:")
    user.name = "Alice K."
}