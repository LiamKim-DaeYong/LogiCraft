package com.logicraft.masterdata.adapter.`in`.dto.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand
import com.logicraft.masterdata.domain.warehouse.Warehouse

object WarehouseDtoMapper {
    fun toWarehouseResponse(entity: Warehouse): WarehouseResponse {
        return WarehouseResponse(
            id = entity.id.value,
            name = entity.name.value,
            type = entity.type,
            address = entity.address,
            operatingHours = entity.operatingHours,
            usagePurpose = entity.usagePurpose,
            status = entity.status.name
        )
    }

    fun toCreateWarehouseCommand(request: CreateWarehouseRequest): CreateWarehouseCommand {
        return CreateWarehouseCommand(
            name = request.name,
            type = request.type,
            address = request.address,
            operatingHours = request.operatingHours,
            usagePurpose = request.usagePurpose
        )
    }

    fun toUpdateWarehouseCommand(warehouseId: String, request: UpdateWarehouseRequest): UpdateWarehouseCommand {
        return UpdateWarehouseCommand(
            warehouseId = warehouseId,
            name = request.name,
            address = request.address,
            operatingHours = request.operatingHours,
            usagePurpose = request.usagePurpose
        )
    }
}
