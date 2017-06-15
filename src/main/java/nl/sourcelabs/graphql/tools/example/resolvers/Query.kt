package nl.sourcelabs.graphql.tools.example.resolvers

import com.coxautodev.graphql.tools.GraphQLRootResolver
import nl.sourcelabs.graphql.tools.example.OrderRepository
import nl.sourcelabs.graphql.tools.example.types.Cancellation
import nl.sourcelabs.graphql.tools.example.types.Order
import nl.sourcelabs.graphql.tools.example.types.OrderItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class Query : GraphQLRootResolver {

    @Autowired
    lateinit var orderRepository: OrderRepository

    open fun order(orderId: String?): Order? {
        return if (orderId != null) orderRepository.orders[orderId] else orderRepository.orders.values.first()
    }

    open fun orderItem(orderItemId: String?): OrderItem? {
        return orderRepository.orders.values.flatMap { it.orderItems.filter { it.orderItemId == orderItemId }  }.firstOrNull()
    }

    open fun cancellations(orderItemId: String?): List<Cancellation>? {
        val values: List<Cancellation>? = orderRepository.cancellations
        return values?.filter { it.orderItemId == orderItemId }
    }
}
