package com.logicraft.masterdata.adapter.`in`.dto.warehouse.response

import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

data class UpdateWarehouseResponse(
    val id: String,
    val name: String,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
    val status: String
)