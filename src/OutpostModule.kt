abstract class OutpostModule (
    val name: String,
    var level: Int = 1
){
    fun upgrade(){
        level++
        println("$name is upgrade to $level")
    }
    abstract fun performAction(manager: ResourceManager)
}