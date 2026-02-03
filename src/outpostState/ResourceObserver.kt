package outpostState

import kotlin.properties.Delegates

class ResourceObserver(val observerName: String) {
    var lastChange: String by Delegates.observable("") { _, old, new ->
        println("[$observerName] $new")
    }

    fun onResourceChanged(resourceName: String, oldValue: Int, newValue: Int) {
        lastChange = "Resource '$resourceName' changed: $oldValue → $newValue"
    }
}