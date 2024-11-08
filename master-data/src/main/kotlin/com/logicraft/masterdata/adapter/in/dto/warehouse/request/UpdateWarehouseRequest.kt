package com.logicraft.masterdata.adapter.`in`.dto.warehouse.request

import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose

data class UpdateWarehouseRequest(
    val name: String,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)