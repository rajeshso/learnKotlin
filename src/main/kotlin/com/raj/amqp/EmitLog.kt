package com.raj.amqp

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.Connection
import com.rabbitmq.client.Channel

object EmitLog {

    private val EXCHANGE_NAME = "logs"

    @Throws(Exception::class)
    @JvmStatic
    fun main(argv: Array<String>) {
        val factory = ConnectionFactory()
        factory.host = "172.17.0.2"
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT)

        val message = getMessage(argv)

        channel.basicPublish(EXCHANGE_NAME, "", null, message.toByteArray(charset("UTF-8")))
        println(" [x] Sent '$message'")

        channel.close()
        connection.close()
    }

    private fun getMessage(strings: Array<String>): String {
        return if (strings.size < 1) "info: Hello World!" else joinStrings(strings, " ")
    }

    private fun joinStrings(strings: Array<String>, delimiter: String): String {
        val length = strings.size
        if (length == 0) return ""
        val words = StringBuilder(strings[0])
        for (i in 1 until length) {
            words.append(delimiter).append(strings[i])
        }
        return words.toString()
    }
}