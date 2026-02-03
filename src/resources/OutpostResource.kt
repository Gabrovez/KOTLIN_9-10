package resources

import kotlin.properties.Delegates

data class OutpostResource(
    val id: Int,
    val name: String,
    val amountInit: Int,
){
    var amount: Int by Delegates.observable(amountInit) { _, old, new -> println("Resource[$name] changed: $old -> $new") }
    override fun toString(): String {
        return "Your resource: $id | name : $name | amount: $amount"
    }
}
fun main(){
    val gas = OutpostResource(1, "Gas", 100)
    val mineral = OutpostResource(2, "Mineral", 250)
    println("Success! You have mined some extra minerals: ${mineral.amount + 50}")
    val bonusMineral = mineral.copy(id = 3, name = "Mineral Bonus", amountInit = mineral.amount + 50)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMineral.toString())

}
