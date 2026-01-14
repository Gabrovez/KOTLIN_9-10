class ResourceManager {
    private val resources = mutableListOf<OutpostResource>()
    fun add(resource: OutpostResource) {
        resources.add(resource)
        println("Added resource: ${resource.name}")
    }
    fun get(name: String):OutpostResource? {
        return resources.find { it.name == name }
    }
    fun printAll(){
        println("Resources of base")
        resources.forEach { println("${it.name}: ${it.amount}")}
    }
}

