package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.CommandEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper.toCreateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseUseCase
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class CreateWarehouseEventHandler(
    private val createWarehouseUseCase: CreateWarehouseUseCase,
): EventProcessor<CreateWarehouseEvent> {

    @EventListener
    override fun handle(event: CreateWarehouseEvent) {
        val warehouse  = createWarehouseUseCase.createWarehouse(event.command)
        val response = warehouse.toCreateWarehouseResponse()

        EventResponseHandler.completeEvent(event, response)
    }
}

data class CreateWarehouseEvent(
    val createWarehouseCommand: CreateWarehouseCommand,
    override val eventType: EventType = WarehouseEventType.CreateWarehouse,
) : CommandEvent<CreateWarehouseCommand>(
    command = createWarehouseCommand,
    eventType = eventType
)