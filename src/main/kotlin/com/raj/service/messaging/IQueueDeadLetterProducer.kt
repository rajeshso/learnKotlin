package com.raj.services.messaging

interface IQueueDeadLetterProducer<in Message> {
    fun publish(message: Message, isFatal: Boolean = false)
}