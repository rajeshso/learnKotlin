package com.raj.services.messaging

import com.rabbitmq.client.AMQP

class RabbitMqProducer<T : String>(
        private val rabbitProducerConfiguration: RabbitProducerConfiguration,
        private val rabbitConnectionProvider: RabbitMqConnectionProvider
) : IQueueProducer<T> {

    override fun publish(message: T) {

    }
}