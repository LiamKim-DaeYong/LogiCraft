package com.logicraft.common.event

import com.logicraft.common.exception.InfrastructureException
import java.time.LocalDateTime
import java.util.*

interface Event {
    val eventType: EventType
    val metadata: EventMetadata

    fun getCorrelationId(): String {
        return metadata.correlationId
            ?: throw InfrastructureException.MissingCorrelationIdException("Event must have a correlationId for event type: ${eventType.typeName}")
    }
}

interface EventType {
    val typeName: String
}

object EmptyQuery

@Suppress("UNCHECKED_CAST")
abstract class QueryEvent<T>(
    val query: T = EmptyQuery as T,
    override val eventType: EventType,
    override val metadata: EventMetadata = EventMetadata()
) : Event

abstract class CommandEvent<T>(
    val command: T,
    override val eventType: EventType,
    override val metadata: EventMetadata = EventMetadata()
) : Event

data class EventMetadata(
    val correlationId: String? = generateCorrelationId(),
    val initiatedBy: String? = null,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun generateCorrelationId(): String {
            return UUID.randomUUID().toString()
        }
    }
}