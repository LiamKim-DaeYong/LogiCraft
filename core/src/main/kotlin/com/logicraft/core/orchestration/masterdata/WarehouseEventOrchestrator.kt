package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.EventOrchestration
import com.logicraft.core.event.EventPublisher
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.CreateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.UpdateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.WarehouseResponse
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.CreateWarehouseEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.FindAllWarehousesEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.FindWarehouseEvent
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.UpdateWarehouseEvent
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseQuery
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand

interface WarehouseEventOrchestrator {
    suspend fun fetchAllWarehouses(): List<WarehouseResponse>

    suspend fun fetchWarehouseById(warehouseId: String): WarehouseResponse

    suspend fun createWarehouse(createWarehouseCommand: CreateWarehouseCommand): CreateWarehouseResponse

    suspend fun updateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand): UpdateWarehouseResponse
}

@EventOrchestration
class WarehouseEventOrchestratorImpl(
    private val eventPublisher: EventPublisher,
) : WarehouseEventOrchestrator {
    override suspend fun fetchAllWarehouses(): List<WarehouseResponse> {
        return eventPublisher.publishAndWaitForResponse(
            event = FindAllWarehousesEvent(),
        )
    }

    override suspend fun fetchWarehouseById(warehouseId: String): WarehouseResponse {
        return eventPublisher.publishAndWaitForResponse(
            event = FindWarehouseEvent(FindWarehouseQuery(warehouseId)),
        )
    }

    override suspend fun createWarehouse(createWarehouseCommand: CreateWarehouseCommand): CreateWarehouseResponse {
        return eventPublisher.publishAndWaitForResponse(
            event = CreateWarehouseEvent(createWarehouseCommand),
        )
    }

    override suspend fun updateWarehouse(updateWarehouseCommand: UpdateWarehouseCommand): UpdateWarehouseResponse {
        return eventPublisher.publishAndWaitForResponse(
            event = UpdateWarehouseEvent(updateWarehouseCommand),
        )
    }
}
