package com.logicraft.common.event

import kotlinx.coroutines.CompletableDeferred

object EventResponseHandler {
    private val callbacks = mutableMapOf<String, CompletableDeferred<*>>()

    @Suppress("UNCHECKED_CAST")
    fun <T> registerCallback(event: Event, deferred: CompletableDeferred<T>) {
        event.metadata.correlationId?.let { correlationId ->
            callbacks[correlationId] = deferred as CompletableDeferred<*>
        } ?: println("Warning: Event does not have a correlationId")
    }

    fun completeEvent(correlationId: String, result: Any) {
        val callback = callbacks.remove(correlationId) as? CompletableDeferred<Any>
        if (callback != null) {
            callback.complete(result)
        } else {
            println("Warning: No callback found for correlationId: $correlationId")
        }
    }
}