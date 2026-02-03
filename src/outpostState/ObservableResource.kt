package outpostState

import kotlin.properties.Delegates

class ObservableResource(
    val name: String,
    amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit) { _, old, new -> println("Resource $name changed: $old → $new")     }
}