package com.logicraft.core.dto.masterdata

import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

data class CreateWarehouseDto(
    val name: String,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)

data class UpdateWarehouseDto(
    val name: String,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)
