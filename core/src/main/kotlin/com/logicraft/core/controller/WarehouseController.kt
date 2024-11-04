package com.logicraft.core.controller

import com.logicraft.core.dto.ApiResponse
import com.logicraft.core.dto.masterdata.CreateWarehouseDto
import com.logicraft.core.dto.masterdata.UpdateWarehouseDto
import com.logicraft.core.dto.masterdata.WarehouseDtoMapper
import com.logicraft.core.orchestration.masterdata.WarehouseOrchestration
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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
    suspend fun createWarehouse(@RequestBody createWarehouseDto: CreateWarehouseDto): ApiResponse<String>  {
        val warehouseId = warehouseOrchestration.handleCreateWarehouse(
            WarehouseDtoMapper.toCreateWarehouseCommand(createWarehouseDto)
        )

        return ApiResponse.created(
            message = "Warehouse created successfully",
            data = warehouseId
        )
    }

    @PatchMapping("/{warehouseId}")
    suspend fun updateWarehouse(
        @PathVariable warehouseId: String,
        @RequestBody updateWarehouseDto: UpdateWarehouseDto
    ): ApiResponse<String>  {
        warehouseOrchestration.handleUpdateWarehouse(
            WarehouseDtoMapper.toUpdateWarehouseCommand(
                warehouseId = warehouseId,
                dto = updateWarehouseDto
            )
        )

        return ApiResponse.success(message = "Warehouse updated successfully")
    }
}