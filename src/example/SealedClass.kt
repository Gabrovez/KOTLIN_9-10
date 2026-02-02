package example

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}
fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success ->{
            println("Success: ${result.data}")
        }
        is NetworkResult.Error ->{
            println("Error: ${result.code}: ${result.message}")
        }
        NetworkResult.Loading ->{
            println("Loading...")
        }
    }
}
sealed class OrderStatus {
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()

}
fun handleOrder(status: OrderStatus) {
    when (status) {
        OrderStatus.Created -> println("Order created")
        OrderStatus.Paid -> println("Order paid")
        OrderStatus.Shipped -> println("Order shipped")
        is OrderStatus.Cancelled -> println("Cancelled: ${status.reason}    ")
    }
}
fun main(){
    handleOrder(OrderStatus.Created)
    handleOrder(OrderStatus.Paid)
    handleOrder(OrderStatus.Shipped)
    handleOrder(OrderStatus.Cancelled("Out of stock"))
//    val success = NetworkResult.Success("Data received")
//    val error = NetworkResult.Error("Server is not responding", 500)
//    val loading = NetworkResult.Loading
//
//    handleResult(success)
//    handleResult(error)
//    handleResult(loading)
}