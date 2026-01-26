package modules

import resources.ResourceManager

class ResearchLab: OutpostModule(
    "Research Lab"
) {
    override fun performAction(manager: ResourceManager) {
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30) {
            println("Not enough minerals for research")
            return
        } else{
            minerals.amount -= 30
            println("Lab is researching ( minerals -30)")
        }
    }
}