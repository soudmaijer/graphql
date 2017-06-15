package nl.sourcelabs.graphql.tools.example

import nl.sourcelabs.graphql.tools.example.types.Cancellation
import nl.sourcelabs.graphql.tools.example.types.Order
import nl.sourcelabs.graphql.tools.example.types.OrderItem
import org.springframework.stereotype.Component

@Component
open class OrderRepository {

    var orderMap: Map<String, Order> = addOrders()
    var cancellationsMap: List<Cancellation> = addCancellations()

    /**
     * Map from orderId to Order
     */
    fun addOrders(): Map<String, Order> {
        return mapOf(
                "1" to Order(orderId = "1", orderItems = listOf(OrderItem("1", "iPhone 8", 2), OrderItem("2", "Galaxy S9", 4), OrderItem("3", "Nokia 3310", 100)))
        )
    }

    /**
     * Map from orderItemId to cancellations
     */
    fun addCancellations(): List<Cancellation> {
        return listOf(Cancellation(orderId = "1", reason = "FRAUD", quantityCancelled = 1, orderItemId = "1"))
    }

    val orders: Map<String, Order>
        get() = orderMap

    val cancellations: List<Cancellation>?
        get() = cancellationsMap
}
