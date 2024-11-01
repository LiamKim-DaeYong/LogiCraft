package com.logicraft.core.event

import com.logicraft.common.event.Event
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

interface EventPublisher {
    fun publish(event: Event)
}

@Component
class SpringEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) : EventPublisher {
    override fun publish(event: Event) {
        applicationEventPublisher.publishEvent(event)
    }
}