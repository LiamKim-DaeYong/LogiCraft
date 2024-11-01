package com.logicraft.common.event

import java.time.LocalDateTime

abstract class BaseEvent(
    override val eventType: EventType
) : Event {
    override val timestamp: LocalDateTime = LocalDateTime.now()
}