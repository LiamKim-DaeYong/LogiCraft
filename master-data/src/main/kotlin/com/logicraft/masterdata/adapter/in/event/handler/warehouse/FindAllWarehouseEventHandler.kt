package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.common.event.QueryEvent
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper.toWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.FindAllWarehousesUseCase
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseQuery
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class FindAllWarehousesEventHandler(
    private val findAllWarehousesUseCase: FindAllWarehousesUseCase,
) : EventProcessor<FindAllWarehousesEvent> {
    @EventListener
    override fun handle(event: FindAllWarehousesEvent) {
        val warehouses = findAllWarehousesUseCase.findAllWarehouses()
        val responses = warehouses.map { it.toWarehouseResponse() }

        EventResponseHandler.completeEvent(event, responses)
    }
}

data class FindAllWarehousesEvent(
    override val eventType: EventType = WarehouseEventType.FindAllWarehouses,
) : QueryEvent<FindWarehouseQuery>(
        eventType = eventType,
    )
