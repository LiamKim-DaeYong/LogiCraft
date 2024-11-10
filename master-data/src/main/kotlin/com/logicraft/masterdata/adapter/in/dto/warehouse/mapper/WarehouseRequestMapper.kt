package com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper

import com.logicraft.masterdata.adapter.`in`.dto.warehouse.request.CreateWarehouseRequest
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.request.UpdateWarehouseRequest
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand

fun CreateWarehouseRequest.toCreateWarehouseCommand(): CreateWarehouseCommand {
    return CreateWarehouseCommand(
        name = name,
        type = type,
        address = address,
        operatingHours = operatingHours,
        usagePurpose = usagePurpose,
    )
}

fun UpdateWarehouseRequest.toUpdateWarehouseCommand(warehouseId: String): UpdateWarehouseCommand {
    return UpdateWarehouseCommand(
        warehouseId = warehouseId,
        name = name,
        address = address,
        operatingHours = operatingHours,
        usagePurpose = usagePurpose,
    )
}
