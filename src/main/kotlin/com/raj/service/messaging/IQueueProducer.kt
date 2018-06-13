package com.raj.services.messaging

interface IQueueProducer<Message> {
    fun publish(message: Message)
}