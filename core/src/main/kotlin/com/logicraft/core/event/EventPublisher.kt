package com.logicraft.core.event

import com.logicraft.common.event.Event
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.exception.InfrastructureException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

interface EventPublisher {

    fun publish(event: Event)
    suspend fun <T> publishAndWaitForResponse(event: Event): T
}

@Component
class SpringEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val properties: EventPublisherProperties,
) : EventPublisher {

    override fun publish(event: Event) {
        try {
            applicationEventPublisher.publishEvent(event)
        } catch (ex: Exception) {
            throw InfrastructureException.EventPublishingException(
                "Failed to publish event: ${event.eventType}",
                ex
            )
        }
    }

    override suspend fun <T> publishAndWaitForResponse(event: Event): T {
        val deferredResponse = CompletableDeferred<T>()
        EventResponseHandler.registerCallback(event, deferredResponse)

        var attempt = 0
        while (attempt < properties.maxRetries) {
            try {
                applicationEventPublisher.publishEvent(event)
                return withTimeout(properties.timeoutMillis) { deferredResponse.await() }
            } catch (ex: Exception) {
                attempt++

                if (attempt >= properties.maxRetries) {
                    throw InfrastructureException.EventPublishingException(
                        "Event publishing failed after ${properties.maxRetries} attempts",
                        ex
                    )
                } else {
                    delay(properties.retryDelayMillis)
                }
            }
        }

        throw InfrastructureException.EventPublishingException("Unexpected error in event publishing")
    }
}
