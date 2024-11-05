package com.logicraft.core.controller

import com.logicraft.core.response.ApiResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.CreateWarehouseRequest
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.UpdateWarehouseRequest
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseDtoMapper
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.WarehouseResponse
import com.logicraft.core.orchestration.masterdata.WarehouseEventOrchestrator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouses")
class WarehouseController(
    private val warehouseEventOrchestrator: WarehouseEventOrchestrator
) {
    @GetMapping
    suspend fun getAllWarehouses(): ApiResponse<List<WarehouseResponse>> {
        val warehouses = warehouseEventOrchestrator.fetchAllWarehouses()
        return ApiResponse.success(
            message = "Warehouses retrieved successfully",
            data = warehouses
        )
    }

    @GetMapping("/{warehouseId}")
    suspend fun getWarehouseById(@PathVariable warehouseId: String): ApiResponse<WarehouseResponse> {
        val warehouse = warehouseEventOrchestrator.fetchWarehouseById(warehouseId)
        return ApiResponse.success(
            message = "Warehouse retrieved successfully",
            data = warehouse
        )
    }

    @PostMapping
    suspend fun createWarehouse(@RequestBody createWarehouseRequest: CreateWarehouseRequest): ApiResponse<String> {
        val warehouseId = warehouseEventOrchestrator.createWarehouse(
            WarehouseDtoMapper.toCreateWarehouseCommand(createWarehouseRequest)
        )

        return ApiResponse.created(
            message = "Warehouse created successfully",
            data = warehouseId
        )
    }

    @PatchMapping("/{warehouseId}")
    suspend fun updateWarehouse(
        @PathVariable warehouseId: String,
        @RequestBody updateWarehouseRequest: UpdateWarehouseRequest
    ): ApiResponse<String>  {
        warehouseEventOrchestrator.updateWarehouse(
            WarehouseDtoMapper.toUpdateWarehouseCommand(
                warehouseId = warehouseId,
                request = updateWarehouseRequest
            )
        )

        return ApiResponse.success(message = "Warehouse updated successfully")
    }
}