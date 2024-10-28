package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.core.model.Address
import com.masterdata.domain.warehouse.OperatingHours
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.enums.UsagePurpose
import com.masterdata.domain.warehouse.enums.WarehouseType

@UseCase
interface RegisterWarehouseUseCase {
    fun registerWarehouse(command: RegisterWarehouseCommand): Warehouse
}

data class RegisterWarehouseCommand(
    val name: String,
    val address: Address,
    val type: WarehouseType,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose
)

