package com.logicraft.core.controller

import com.logicraft.common.response.ApiResponse
import com.logicraft.core.orchestration.masterdata.WarehouseEventOrchestrator
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper.toCreateWarehouseCommand
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper.toUpdateWarehouseCommand
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.request.CreateWarehouseRequest
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.request.UpdateWarehouseRequest
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.CreateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.UpdateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.WarehouseResponse
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
    private val warehouseEventOrchestrator: WarehouseEventOrchestrator,
) {
    @GetMapping
    suspend fun getAllWarehouses(): ApiResponse<List<WarehouseResponse>> {
        return warehouseEventOrchestrator.fetchAllWarehouses().let {
            ApiResponse.success(
                message = "Warehouses retrieved successfully",
                data = it,
            )
        }
    }

    @GetMapping("/{warehouseId}")
    suspend fun getWarehouseById(
        @PathVariable warehouseId: String,
    ): ApiResponse<WarehouseResponse> {
        return warehouseEventOrchestrator.fetchWarehouseById(warehouseId).let {
            ApiResponse.success(
                message = "Warehouse retrieved successfully",
                data = it,
            )
        }
    }

    @PostMapping
    suspend fun createWarehouse(
        @RequestBody createWarehouseRequest: CreateWarehouseRequest,
    ): ApiResponse<CreateWarehouseResponse> {
        return warehouseEventOrchestrator.createWarehouse(
            createWarehouseRequest.toCreateWarehouseCommand(),
        ).let {
            ApiResponse.created(
                message = "Warehouse created successfully",
                data = it,
            )
        }
    }

    @PatchMapping("/{warehouseId}")
    suspend fun updateWarehouse(
        @PathVariable warehouseId: String,
        @RequestBody updateWarehouseRequest: UpdateWarehouseRequest,
    ): ApiResponse<UpdateWarehouseResponse> {
        return warehouseEventOrchestrator.updateWarehouse(
            updateWarehouseRequest.toUpdateWarehouseCommand(warehouseId),
        ).let {
            ApiResponse.success(
                message = "Warehouse updated successfully",
                data = it,
            )
        }
    }
}
