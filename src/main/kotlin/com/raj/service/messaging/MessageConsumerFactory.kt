package com.raj.services.messaging

import com.rabbitmq.client.Channel
import com.rabbitmq.client.Consumer

class MessageConsumerFactory(
        private val rabbitConnectionProvider: RabbitMqConnectionProvider) {

    fun <T : String> getMessageConsumer(
            channel: Channel,
            type: Class<T>,
            maxRetries: Int): Consumer {
        return when {
            type.isAssignableFrom(String::class.java) -> {
               IssuanceMessageConsumer(channel)
            }
            else -> throw ClassNotFoundException()
        }
    }
}