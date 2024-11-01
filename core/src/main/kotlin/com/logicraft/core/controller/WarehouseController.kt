package com.logicraft.core.controller

import com.logicraft.core.orchestration.masterdata.WarehouseOrchestration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouses")
class WarehouseController(
    private val warehouseOrchestration: WarehouseOrchestration
) {

    @PostMapping
    suspend fun createWarehouse() {
        warehouseOrchestration.handleCreateWarehouse()
    }
}