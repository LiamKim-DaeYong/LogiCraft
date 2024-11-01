package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventListener
import com.logicraft.common.event.BaseEvent
import com.logicraft.common.event.EventProcessor
import com.logicraft.common.event.EventType
import com.logicraft.masterdata.adapter.`in`.event.type.WarehouseEventType
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseUseCase

@EventListener
class CreateWarehouseEventHandler(
    private val createWarehouseUseCase: CreateWarehouseUseCase,
): EventProcessor<CreateWarehouseEvent> {

    override fun handle(event: CreateWarehouseEvent) {
        //createWarehouseUseCase.createWarehouse()
    }
}

data class CreateWarehouseEvent(
    val warehouseId: String,
    val warehouseName: String,
    override val eventType: EventType = WarehouseEventType.CREATE_WAREHOUSE
) : BaseEvent(eventType)