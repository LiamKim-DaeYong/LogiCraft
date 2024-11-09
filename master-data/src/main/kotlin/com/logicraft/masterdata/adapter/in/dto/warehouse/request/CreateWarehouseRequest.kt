package com.logicraft.masterdata.adapter.`in`.dto.warehouse.request

import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

data class CreateWarehouseRequest(
    val name: String,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
)
