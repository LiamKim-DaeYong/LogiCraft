package com.masterdata.domain.warehouse

import com.core.enums.ActiveStatus
import com.core.model.Address
import com.masterdata.domain.warehouse.enums.UsagePurpose
import com.masterdata.domain.warehouse.enums.WarehouseType
import java.time.LocalTime

data class Warehouse(
    val id: WarehouseId,
    val name: WarehouseName,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
    val status: ActiveStatus,
)

@JvmInline
value class WarehouseId(val id: String)

@JvmInline
value class WarehouseName(val value: String)

data class OperatingHours(val openingTime: LocalTime, val closingTime: LocalTime)