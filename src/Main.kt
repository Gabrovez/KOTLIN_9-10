import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager
import modules.ModuleResult
fun handleModuleResult (result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("Success: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Produced: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println("Not enough resource ${result.resourceName}. + Need: ${result.required}, have   : ${result.available}")
        is ModuleResult.Error ->
            println("Error: ${result.reason}")
        }
    }
fun  main (){

    val manager = ResourceManager()
    val minerals = OutpostResource(1, "Minerals", 120)
    val gas = OutpostResource(2, "Gas", 40)
    manager.add(minerals)
    manager.add(gas)
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
}