package nl.sourcelabs.graphql.tools.example

import nl.sourcelabs.graphql.tools.example.types.Cancellation
import nl.sourcelabs.graphql.tools.example.types.Order
import nl.sourcelabs.graphql.tools.example.types.OrderItem
import org.springframework.stereotype.Component

@Component
open class OrderRepository {

    val orderMap: Map<String, Order> = mapOf("1" to Order(orderId = "1", orderItems = listOf(OrderItem("1", "iPhone 8", 2), OrderItem("2", "Galaxy S9", 4), OrderItem("3", "Nokia 3310", 100))))
    val cancellations: List<Cancellation> = listOf(Cancellation(orderId = "1", reason = "FRAUD", quantityCancelled = 1, orderItemId = "1"))
}