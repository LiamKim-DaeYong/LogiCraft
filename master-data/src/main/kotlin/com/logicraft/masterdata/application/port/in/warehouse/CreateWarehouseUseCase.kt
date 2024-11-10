package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

@UseCase
interface CreateWarehouseUseCase {
    fun createWarehouse(command: CreateWarehouseCommand): Warehouse
}

data class CreateWarehouseCommand(
    val name: String,
    val address: Address,
    val type: WarehouseType,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
)
