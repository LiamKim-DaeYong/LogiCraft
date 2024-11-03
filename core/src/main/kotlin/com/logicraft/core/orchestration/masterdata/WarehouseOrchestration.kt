package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.OrchestrationAdapter
import com.logicraft.core.event.EventPublisher
import com.logicraft.masterdata.adapter.`in`.event.handler.warehouse.CreateWarehouseEvent
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand

interface WarehouseOrchestration {
    suspend fun handleCreateWarehouse(createWarehouseCommand: CreateWarehouseCommand): Any
}

@OrchestrationAdapter
class WarehouseOrchestrationImpl(
    private val eventPublisher: EventPublisher
) : WarehouseOrchestration {
    override suspend fun handleCreateWarehouse(createWarehouseCommand: CreateWarehouseCommand): Any {
        val event = CreateWarehouseEvent(createWarehouseCommand = createWarehouseCommand)

        println("Publishing event: $event") // 이벤트 발행 전에 로그 추가
        return eventPublisher.publishAndWaitForResponse(event)
    }
}