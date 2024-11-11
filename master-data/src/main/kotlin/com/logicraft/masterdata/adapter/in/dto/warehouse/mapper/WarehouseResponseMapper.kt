package com.logicraft.masterdata.adapter.`in`.dto.warehouse.mapper

import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.CreateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.UpdateWarehouseResponse
import com.logicraft.masterdata.adapter.`in`.dto.warehouse.response.WarehouseResponse
import com.logicraft.masterdata.domain.warehouse.Warehouse

fun Warehouse.toWarehouseResponse(): WarehouseResponse {
    return WarehouseResponse(
        id = id.value,
        name = name.value,
        type = type,
        address = address,
        operatingHours = operatingHours,
        usagePurpose = usagePurpose,
        activeStatus = activeStatus.name,
    )
}

fun Warehouse.toCreateWarehouseResponse(): CreateWarehouseResponse {
    return CreateWarehouseResponse(id.value)
}

fun Warehouse.toUpdateWarehouseResponse(): UpdateWarehouseResponse {
    return UpdateWarehouseResponse(
        id = id.value,
        name = name.value,
        type = type,
        address = address,
        operatingHours = operatingHours,
        usagePurpose = usagePurpose,
        activeStatus = activeStatus.name,
    )
}
