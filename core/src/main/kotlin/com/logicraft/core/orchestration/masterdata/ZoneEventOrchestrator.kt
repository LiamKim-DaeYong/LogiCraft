package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.EventOrchestration
import com.logicraft.core.event.EventPublisher
import com.logicraft.masterdata.adapter.`in`.dto.location.response.CreateZoneResponse
import com.logicraft.masterdata.adapter.`in`.event.handler.location.CreateZoneEvent
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneCommand

interface ZoneEventOrchestrator {
    suspend fun createZone(createZoneCommand: CreateZoneCommand): CreateZoneResponse
}

@EventOrchestration
class ZoneEventOrchestratorImpl(
    private val eventPublisher: EventPublisher,
) : ZoneEventOrchestrator {

    override suspend fun createZone(createZoneCommand: CreateZoneCommand): CreateZoneResponse {
        return eventPublisher.publishAndWaitForResponse(
            event = CreateZoneEvent(createZoneCommand)
        )
    }
}
