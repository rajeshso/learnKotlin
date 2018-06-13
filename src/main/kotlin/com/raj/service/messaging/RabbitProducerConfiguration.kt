package com.raj.services.messaging

data class RabbitProducerConfiguration(
        val exchangeName: String,
        val exchangeRoutingKey: String
)