package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventHandlerAdapter
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventResponseHandler
import com.logicraft.common.event.EventType
import com.logicraft.common.event.QueryEvent
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseDtoMapper
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseQuery
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import org.springframework.context.event.EventListener

@EventHandlerAdapter
class FindWarehouseEventHandler(
    private val findWarehouseUseCase: FindWarehouseUseCase
) : EventProcessor<FindWarehouseEvent> {

    @EventListener
    override fun handle(event: FindWarehouseEvent) {
        val warehouse = findWarehouseUseCase.findWarehouse(event.query)
        val response = WarehouseDtoMapper.toWarehouseResponse(warehouse)

        event.metadata.correlationId?.let { correlationId ->
            EventResponseHandler.completeEvent(correlationId, response)
        }
    }
}

data class FindWarehouseEvent(
    val findWarehouseQuery: FindWarehouseQuery,
    override val eventType: EventType = WarehouseEventType.FindWarehouse
) : QueryEvent<FindWarehouseQuery>(
    query = findWarehouseQuery,
    eventType = eventType
)