package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.OrchestrationAdapter
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseResponse
import com.logicraft.core.event.EventPublisher
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.CreateWarehouseEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.FindAllWarehousesEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.FindWarehouseEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.UpdateWarehouseEvent
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand

interface WarehouseEventOrchestrator {
    suspend fun fetchAllWarehouses(): List<WarehouseResponse>
    suspend fun fetchWarehouseById(warehouseId: String): WarehouseResponse
    suspend fun createWarehouse(createWarehouseCommand: CreateWarehouseCommand): String
    suspend fun updateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand)
}

@OrchestrationAdapter
class WarehouseEventOrchestratorImpl(
    private val eventPublisher: EventPublisher
) : WarehouseEventOrchestrator {
    override suspend fun fetchAllWarehouses(): List<WarehouseResponse> {
        val event = FindAllWarehousesEvent(FindWarehouseCommand(""))
        return eventPublisher.publishAndWaitForResponse(event)
    }

    override suspend fun fetchWarehouseById(warehouseId: String): WarehouseResponse {
        val event = FindWarehouseEvent(FindWarehouseCommand(warehouseId))
        return eventPublisher.publishAndWaitForResponse(event)
    }

    override suspend fun createWarehouse(createWarehouseCommand: CreateWarehouseCommand): String {
        val event = CreateWarehouseEvent(createWarehouseCommand)
        return eventPublisher.publishAndWaitForResponse(event)
    }

    override suspend fun updateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand) {
        val event = UpdateWarehouseEvent(updateWarehouseCommand)
        eventPublisher.publish(event)
    }
}