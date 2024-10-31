package com.logicraft.masterdata.domain.warehouse

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType
import java.time.LocalTime

class Warehouse(
    val id: WarehouseId,
    val name: WarehouseName,
    val type: WarehouseType,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
    val status: ActiveStatus,
)

@JvmInline
value class WarehouseId(val value: String)

@JvmInline
value class WarehouseName(val value: String)

data class OperatingHours(val openingTime: LocalTime, val closingTime: LocalTime)