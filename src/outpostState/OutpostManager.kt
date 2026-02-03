package outpostState

class OutpostManager {
    val _resources = mutableListOf<ObservableResource>()

    fun addResource(resource: ObservableResource) {
        _resources.add(resource)
        println("Resource '${resource.name}' (amount: ${resource.amount}) added")
    }
}

val outpostManager by lazy {
    println("OutpostManager created")
    OutpostManager()
}