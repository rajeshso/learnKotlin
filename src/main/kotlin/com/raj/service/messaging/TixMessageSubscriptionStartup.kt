package com.raj.services.messaging

import com.rabbitmq.client.ConnectionFactory

object TixMessageSubscriptionStartup {

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Reached TixMessageSub")
        doSomeWork()
    }

    fun doSomeWork() {
        try {
            println("Initializing RabbitMQ Subscriptions - this should happen only once")

            val connectionFactory = ConnectionFactory()
            connectionFactory.host = "172.17.0.2"

            val connectionProvider = RabbitMqConnectionProvider(connectionFactory)

            val issueConsumeConfiguration = RabbitConsumerConfiguration(
                        exchangeName = "tixcorda_messaging",
                        exchangeRoutingKey = "issue_asset",
                        queueName = "issue_asset_request_queue"
                )

                val transactionResponseConfiguration = RabbitProducerConfiguration(
                        exchangeName = "tixcorda_messaging",
                        exchangeRoutingKey = "cordatix_response"
                )

                val messageConsumerFactory = MessageConsumerFactory(
                        rabbitConnectionProvider = connectionProvider
                )

                val tradeIssuanceConsumer = RabbitMqConsumer(
                        rabbitConsumerConfiguration = issueConsumeConfiguration,
                        messageClass = String::class.java,
                        rabbitConnectionProvider = connectionProvider,
                        messageConsumerFactory = messageConsumerFactory
                )

                tradeIssuanceConsumer.subscribe()
                println("RabbitMQ subscriptions done")
        } catch (ex: Throwable) {
            println("Oooh Exception")
            ex.printStackTrace()
            throw ex
        }
    }
}