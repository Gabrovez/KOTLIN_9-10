package outpostState

fun main() {
    val manager = outpostManager
    manager.addResource(ObservableResource("Minerals", 100))
    manager.addResource(ObservableResource("Energy", 50))
    manager.addResource(ObservableResource("Water", 75))

    manager._resources[0].amount = 120
    manager._resources[1].amount = 65

    StateStorage.save(manager._resources)

    println("\n--- Loading state ---")
    val loaded = StateStorage.load()
    loaded.forEach { println("${it.name}: ${it.amount}") }
}