package com.raj.services.messaging

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory

class RabbitMqConnectionProvider(private val connectionFactory: ConnectionFactory) {


    companion object {
        private var connection: Connection? = null
    }

    fun getConnection(): Connection {
        return if (connection != null && connection!!.isOpen) {
            connection!!
        } else {
            connection = connectionFactory.newConnection()
            connection!!
        }
    }
}