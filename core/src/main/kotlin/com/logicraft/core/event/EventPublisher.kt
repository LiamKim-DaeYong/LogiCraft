package com.logicraft.core.event

import com.logicraft.common.event.Event
import com.logicraft.common.event.EventResponseHandler
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.withTimeout
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

interface EventPublisher {
    fun publish(event: Event)

    suspend fun <T> publishAndWaitForResponse(event: Event): T
}

@Component
class SpringEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
    @Value("\${event.publisher.timeout}") private val timeoutMillis: Long
) : EventPublisher {

    override fun publish(event: Event) {
        applicationEventPublisher.publishEvent(event)
    }

    override suspend fun <T> publishAndWaitForResponse(event: Event): T {
        val deferredResponse = CompletableDeferred<T>()
        EventResponseHandler.registerCallback(event, deferredResponse)

        applicationEventPublisher.publishEvent(event)

        return withTimeout(timeoutMillis) {
            deferredResponse.await()
        }
    }
}
