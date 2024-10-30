package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.core.model.Address
import com.masterdata.domain.warehouse.OperatingHours
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.enums.UsagePurpose
import com.masterdata.domain.warehouse.enums.WarehouseType

@UseCase
interface CreateWarehouseUseCase {
    fun createWarehouse(command: CreateWarehouseCommand): Warehouse
}

data class CreateWarehouseCommand(
    val name: String,
    val address: Address,
    val type: WarehouseType,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)

