package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.OrchestrationAdapter
import com.logicraft.core.event.EventPublisher
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.CreateWarehouseEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.UpdateWarehouseEvent
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand

interface WarehouseOrchestration {
    suspend fun handleCreateWarehouse(createWarehouseCommand: CreateWarehouseCommand): String
    suspend fun handleUpdateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand)
//    suspend fun handleGetAllWarehouses(): List<WarehouseResponse>
//    suspend fun handleGetWarehouseById(warehouseId: String): WarehouseResponse
}

@OrchestrationAdapter
class WarehouseOrchestrationImpl(
    private val eventPublisher: EventPublisher
) : WarehouseOrchestration {
    override suspend fun handleCreateWarehouse(createWarehouseCommand: CreateWarehouseCommand): String {
        val event = CreateWarehouseEvent(createWarehouseCommand)
        return eventPublisher.publishAndWaitForResponse(event)
    }

    override suspend fun handleUpdateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand) {
        val event = UpdateWarehouseEvent(updateWarehouseCommand)
        eventPublisher.publish(event)
    }
}