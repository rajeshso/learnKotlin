package com.raj.services.messaging

import com.rabbitmq.client.AMQP
import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import java.io.IOException
import java.nio.charset.Charset

class RabbitMqConsumer<T : String>(
        private val rabbitConsumerConfiguration: RabbitConsumerConfiguration,
        private val messageClass: Class<T>,
        private val rabbitConnectionProvider: RabbitMqConnectionProvider,
        private val messageConsumerFactory: MessageConsumerFactory
) : IQueueConsumer {

    override fun subscribe() {
        val connection = rabbitConnectionProvider.getConnection()
        val channel = connection.createChannel()

        channel?.exchangeDeclare(
                rabbitConsumerConfiguration.exchangeName,
                BuiltinExchangeType.FANOUT
                )

        val queueDeclare = channel?.queueDeclare(
                rabbitConsumerConfiguration.queueName,
                true,
                true,
                true,
                emptyMap()
                )


        val assignedQueueName = queueDeclare?.queue

        channel?.queueBind(
                assignedQueueName,
                rabbitConsumerConfiguration.exchangeName,
                rabbitConsumerConfiguration.exchangeRoutingKey)

        val consumer = messageConsumerFactory.getMessageConsumer(
                channel!!,
                messageClass,
                0
         )



        val consumer1 = object : DefaultConsumer(channel) {
            @Throws(IOException::class)
            override fun handleDelivery(consumerTag: String?, envelope: Envelope?,
                                        properties: AMQP.BasicProperties?, body: ByteArray?) {
                val message = String(body!!, Charset.defaultCharset())
                println(" [x] Received '$message'")
            }
        }

        channel.basicConsume(assignedQueueName, false, consumer1)
    }
}