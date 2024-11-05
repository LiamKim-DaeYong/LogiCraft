package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.CommandEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseDtoMapper
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class FindWarehouseEventHandler(
    private val findWarehouseUseCase: FindWarehouseUseCase
) : EventProcessor<FindWarehouseEvent> {

    @EventListener
    override fun handle(event: FindWarehouseEvent) {
        val warehouse = findWarehouseUseCase.findWarehouse(event.command)
        val response = WarehouseDtoMapper.toWarehouseResponse(warehouse)

        event.metadata.correlationId?.let { correlationId ->
            EventResponseHandler.completeEvent(correlationId, response)
        }
    }
}

data class FindWarehouseEvent(
    val findWarehouseCommand: FindWarehouseCommand,
    override val eventType: EventType = WarehouseEventType.FIND_WAREHOUSE
) : CommandEvent<FindWarehouseCommand>(
    command = findWarehouseCommand,
    eventType = eventType
)