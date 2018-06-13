package com.raj.amqp

import com.rabbitmq.client.*

import java.io.IOException
import java.nio.charset.Charset

object ReceiveLogs {
    private val EXCHANGE_NAME = "logs"

    @Throws(Exception::class)
    @JvmStatic
    fun main(argv: Array<String>) {
        val factory = ConnectionFactory()
        factory.host = "172.17.0.2"
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT)
        val queueName = channel.queueDeclare().queue
        channel.queueBind(queueName, EXCHANGE_NAME, "")

        println(" [*] Waiting for messages. To exit press CTRL+C")

        val consumer = object : DefaultConsumer(channel) {
            @Throws(IOException::class)
            override fun handleDelivery(consumerTag: String?, envelope: Envelope?,
                                        properties: AMQP.BasicProperties?, body: ByteArray?) {
                val message = String(body!!, Charset.defaultCharset())
                println(" [x] Received '$message'")
            }
        }
        channel.basicConsume(queueName, true, consumer)
    }
}

