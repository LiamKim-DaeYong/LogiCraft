package com.logicraft.masterdata.adapter.`in`.event.handler.location

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.CommandEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.dto.location.mapper.toCreateZoneResponse
import com.logicraft.masterdata.adapter.`in`.event.type.ZoneEventType
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneCommand
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneUseCase
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class CreateZoneEventHandler(
    private val createZoneUseCase: CreateZoneUseCase,
) : EventProcessor<CreateZoneEvent> {
    @EventListener
    override fun handle(event: CreateZoneEvent) {
        val zone = createZoneUseCase.createZone(event.command)
        val response = zone.toCreateZoneResponse()

        EventResponseHandler.completeEvent(event, response)
    }
}

data class CreateZoneEvent(
    val createZoneCommand: CreateZoneCommand,
    override val eventType: EventType = ZoneEventType.CreateZone,
) : CommandEvent<CreateZoneCommand>(
        command = createZoneCommand,
        eventType = eventType,
    )
