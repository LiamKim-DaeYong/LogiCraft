package com.logicraft.common.event

import kotlinx.coroutines.CompletableDeferred
import java.util.concurrent.*

object EventResponseHandler {
    private val callbacks = ConcurrentHashMap<String, CompletableDeferred<*>>()

    fun <T> registerCallback(event: Event, deferred: CompletableDeferred<T>) {
        val correlationId = event.metadata.correlationId
            ?: throw IllegalArgumentException("Event must have a correlationId")

        synchronized(this) {
            callbacks[correlationId] = deferred
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun completeEvent(correlationId: String, result: Any) {
        val callback = synchronized(this) { callbacks.remove(correlationId) }
        if (callback != null) {
            (callback as CompletableDeferred<Any?>).complete(result)
        } else {
            println("Warning: No callback found for correlationId: $correlationId")
        }
    }
}