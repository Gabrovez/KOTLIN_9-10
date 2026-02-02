package modules

import resources.OutpostResource
import resources.ResourceManager


class EnergyGenerator: OutpostModule( "Energy generator") {
    override fun performAction(manager: ResourceManager) : ModuleResult {
        println("Generator is working... Produces 20 energy...")
        val energy = manager.get("Energy")
        return if (energy != null) {
            energy.amount += 20
            ModuleResult.ResourceProduced("Energy", 20)
        }else{
            manager.add(OutpostResource(99, "Energy", 20))
            ModuleResult.Success("Energy created for the first time")
        }
    }
}