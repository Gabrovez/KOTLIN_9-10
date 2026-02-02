package modules

import resources.ResourceManager

class ResearchLab: OutpostModule("Research Lab") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30) {
            return ModuleResult.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }
        minerals.amount -= 30
        return ModuleResult.Success("Research is completed")
    }
}
