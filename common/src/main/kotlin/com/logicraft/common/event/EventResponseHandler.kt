package com.logicraft.common.event

import kotlinx.coroutines.CompletableDeferred

object EventResponseHandler {
    private val callbacks = mutableMapOf<String, CompletableDeferred<Any>>()

    fun registerCallback(event: Event, deferred: CompletableDeferred<Any>) {
        event.metadata.correlationId?.let { correlationId ->
            callbacks[correlationId] = deferred
        } ?: println("Warning: Event does not have a correlationId")
    }

    fun completeEvent(correlationId: String, result: Any) {
        callbacks.remove(correlationId)?.complete(result)
            ?: println("Warning: No callback found for correlationId: $correlationId")
    }
}
