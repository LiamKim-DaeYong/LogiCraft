package com.logicraft.masterdata.adapter.`in`.dto.warehouse

import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

data class WarehouseResponse(
    val id: String,
    val name: String,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
    val status: String
)

data class CreateWarehouseRequest(
    val name: String,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)

data class UpdateWarehouseRequest(
    val name: String,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)
