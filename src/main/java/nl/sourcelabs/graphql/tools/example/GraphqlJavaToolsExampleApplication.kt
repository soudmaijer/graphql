package nl.sourcelabs.graphql.tools.example

import com.coxautodev.graphql.tools.SchemaParserDictionary
import nl.sourcelabs.graphql.tools.example.types.Cancellation
import nl.sourcelabs.graphql.tools.example.types.Order
import nl.sourcelabs.graphql.tools.example.types.OrderItem
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class GraphqlJavaToolsExampleApplication {

    @Bean
    open fun schemaParserDictionary(): SchemaParserDictionary {
        return SchemaParserDictionary().add(dictionary = listOf(Order::class.java, OrderItem::class.java, Cancellation::class.java))
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(GraphqlJavaToolsExampleApplication::class.java, *args)
        }
    }
}
