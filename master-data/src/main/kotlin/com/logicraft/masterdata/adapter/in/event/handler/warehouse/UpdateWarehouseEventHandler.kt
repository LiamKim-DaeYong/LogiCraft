package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.CommandEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper.toUpdateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseUseCase
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class UpdateWarehouseEventHandler(
    private val updateWarehouseUseCase: UpdateWarehouseUseCase,
) : EventProcessor<UpdateWarehouseEvent> {

    @EventListener
    override fun handle(event: UpdateWarehouseEvent) {
        val warehouse = updateWarehouseUseCase.updateWarehouse(event.command)
        val response = warehouse.toUpdateWarehouseResponse()

        EventResponseHandler.completeEvent(event, response)
    }
}

data class UpdateWarehouseEvent(
    val updateWarehouseCommand: UpdateWarehouseCommand,
    override val eventType: EventType = WarehouseEventType.UpdateWarehouse,
) : CommandEvent<UpdateWarehouseCommand>(
    command = updateWarehouseCommand,
    eventType = eventType
)
