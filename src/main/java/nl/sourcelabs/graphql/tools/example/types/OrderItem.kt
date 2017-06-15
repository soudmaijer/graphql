package nl.sourcelabs.graphql.tools.example.types

data class OrderItem constructor(
        var orderItemId: String,
        var productTitle: String,
        var quantityRequested: Long,
        var cancellations: List<Cancellation>? = null

)
