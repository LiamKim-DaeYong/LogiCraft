package com.logicraft.common.event

import java.time.LocalDateTime

interface Event {
    val eventType: EventType
    val timestamp: LocalDateTime
}

