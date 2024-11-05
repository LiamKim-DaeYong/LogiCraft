package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.CommandEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseDtoMapper
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.FindAllWarehousesUseCase
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class FindAllWarehousesEventHandler(
    private val findAllWarehousesUseCase: FindAllWarehousesUseCase
) : EventProcessor<FindAllWarehousesEvent> {

    @EventListener
    override fun handle(event: FindAllWarehousesEvent) {
        val warehouses = findAllWarehousesUseCase.findAllWarehouses()
        val responses = warehouses.map { WarehouseDtoMapper.toWarehouseResponse(it) }

        event.metadata.correlationId?.let { correlationId ->
            EventResponseHandler.completeEvent(correlationId, responses)
        }
    }
}

data class FindAllWarehousesEvent(
    val findWarehouseCommand: FindWarehouseCommand,
    override val eventType: EventType = WarehouseEventType.FIND_ALL_WAREHOUSES
) : CommandEvent<FindWarehouseCommand>(
    command = findWarehouseCommand,
    eventType = eventType
)
