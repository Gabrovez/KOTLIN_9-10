package modules

sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(
        val resourceName: String, val amount: Int
    ) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        var required: Int,
        val available: Int
        ) : ModuleResult()
        data class Error(val reason: String) : ModuleResult()
}