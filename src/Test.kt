var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 1111))
            field = value
    }
data class  Item(
    val id:Int,
    val name: String,
    val quantity:Int
){
    override fun toString(): String {
        return "id of item: $id\nName: $name\nQuantity: $quantity\n"
    }
}
abstract class Human(val name: String){
    abstract var age: Int
    abstract fun hello()
}
class Person(name: String, override var age: Int): Human(name){
    override fun hello() {
        println("My name is $name")
    }
}
fun main(){
//    println(age)
//    age =45
//    println(age)
//    age = -1000
//    println(age)
//    val sword = Item(1, "Sword", 1)
//    val betterSword = sword.copy(quantity = 2)
//    println(sword.toString())
//    println(betterSword.toString())
//    val (id, name, quantity) = betterSword
//    println("id of item: $id\nName: $name\nQuantity: $quantity\n")
//    val pavel:Human(name = "Pavel")

    val denis: Person = Person("Denis", 21)
    val maksim: Human = Person("Maksim", 22)
    denis.hello()
    maksim.hello()
}