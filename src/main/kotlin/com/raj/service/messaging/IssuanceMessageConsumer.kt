package com.raj.services.messaging

import com.rabbitmq.client.*
import java.nio.charset.Charset

class IssuanceMessageConsumer(
        private val channel: Channel
) : Consumer {

    override fun handleRecoverOk(consumerTag: String?) {
        println("IssuanceMessageConsumer: handleRecoverOk for consumer tag: $consumerTag")
    }

    override fun handleConsumeOk(consumerTag: String?) {
        println("IssuanceMessageConsumer: handleConsumeOk for consumer tag: $consumerTag")
    }

    override fun handleShutdownSignal(consumerTag: String?, sig: ShutdownSignalException?) {
        println("IssuanceMessageConsumer: handleShutdownSignal for consumer tag: $consumerTag")
        println(sig)
    }

    override fun handleCancel(consumerTag: String?) {
        println("IssuanceMessageConsumer: handleCancel for consumer tag: $consumerTag")
    }

    override fun handleDelivery(
            consumerTag: String?,
            envelope: Envelope?,
            properties: AMQP.BasicProperties?,
            body: ByteArray?) {
        val deliveryTag = envelope?.deliveryTag

        // Handler logic here
        val messageBody = body?.toString(Charset.defaultCharset())
        println("Received message $messageBody")
        var requestMessage = messageBody

        try {
            println("Received message in IssuanceMessageConsumer - about to ack then process.")
        } catch (ex: Throwable) {
            println("Exception handled in IssuanceMessageConsumer, writing to dlq fatally")
        } finally {
            channel.basicAck(deliveryTag!!, false)
        }
    }

    override fun handleCancelOk(consumerTag: String?) {
        println("IssuanceMessageConsumer: handleCancelOk for consumer tag: $consumerTag")
    }
}