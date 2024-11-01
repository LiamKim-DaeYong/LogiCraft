package com.logicraft.core.orchestration.masterdata

import com.logicraft.common.annotations.OrchestrationAdapter

interface WarehouseOrchestration {
    suspend fun handleCreateWarehouse()
}

@OrchestrationAdapter
class WarehouseOrchestrationImpl : WarehouseOrchestration {
    override suspend fun handleCreateWarehouse() {
        // TODO: 이벤트 발행 (창고 생성 이벤트)
    }
}