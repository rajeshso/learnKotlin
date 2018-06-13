package com.raj.service.messaging

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

object MyRabbitMqConnectionProvider {

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Reached TixMessageSub")
        val c = getConnection()
        println(c)
    }

    fun getConnection(): Connection {
        val connectionFactory = ConnectionFactory()
        connectionFactory.host = "172.17.0.2"
        var connection: Connection? = null
        return if (connection != null && connection!!.isOpen) {
            connection!!
        } else {
            connection = connectionFactory.newConnection()
            connection!!
        }
    }
}