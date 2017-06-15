package nl.sourcelabs.graphql.tools.example.types

data class Cancellation constructor(
        var orderId: String,
        var orderItemId: String,
        var reason: String,
        var quantityCancelled: Long
)
