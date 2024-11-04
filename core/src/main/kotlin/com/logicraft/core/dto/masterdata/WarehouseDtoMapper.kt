package com.logicraft.core.dto.masterdata

import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand

object WarehouseDtoMapper {
    fun toCreateWarehouseCommand(dto: CreateWarehouseDto): CreateWarehouseCommand {
        return CreateWarehouseCommand(
            name = dto.name,
            type = dto.type,
            address = dto.address,
            operatingHours = dto.operatingHours,
            usagePurpose = dto.usagePurpose
        )
    }

    fun toUpdateWarehouseCommand(warehouseId: String, dto: UpdateWarehouseDto): UpdateWarehouseCommand {
        return UpdateWarehouseCommand(
            warehouseId = warehouseId,
            name = dto.name,
            address = dto.address,
            operatingHours = dto.operatingHours,
            usagePurpose = dto.usagePurpose
        )
    }
}
