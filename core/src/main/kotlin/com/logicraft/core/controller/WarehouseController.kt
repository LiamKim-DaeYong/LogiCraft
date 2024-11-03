package com.logicraft.core.controller

import com.logicraft.core.orchestration.masterdata.WarehouseOrchestration
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouses")
class WarehouseController(
    private val warehouseOrchestration: WarehouseOrchestration
) {
    @PostMapping
    suspend fun createWarehouse(@RequestBody createWarehouseCommand: CreateWarehouseCommand) {
        warehouseOrchestration.handleCreateWarehouse(createWarehouseCommand)
    }
}