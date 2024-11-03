package com.logicraft.core.event

import com.logicraft.common.event.Event
import com.logicraft.common.event.EventResponseHandler
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.withTimeout
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

interface EventPublisher {
    suspend fun <T : Event> publishAndWaitForResponse(event: T): Any
}

@Component
class SpringEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) : EventPublisher {

    override suspend fun <T : Event> publishAndWaitForResponse(event: T): Any {
        val deferredResponse = CompletableDeferred<Any>()
        EventResponseHandler.registerCallback(event, deferredResponse)

        applicationEventPublisher.publishEvent(event)

        return withTimeout(5000) {
            deferredResponse.await()
        }
    }
}
