class EnergyGenerator:OutpostModule( "Energy generator") {
    override fun performAction(manager: ResourceManager) {
        println("Generator is working... Produces 20 energy...")
        val energy = manager.get("Energy")
        if (energy != null) {
            energy.amount += 20
        }else{
            manager.add(OutpostResource(99,"Energy",20))
        }
    }
}