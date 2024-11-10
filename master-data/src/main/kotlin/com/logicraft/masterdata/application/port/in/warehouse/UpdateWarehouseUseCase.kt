package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.common.model.Address
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose

@UseCase
interface UpdateWarehouseUseCase {
    fun updateWarehouse(command: UpdateWarehouseCommand): Warehouse
}

data class UpdateWarehouseCommand(
    val warehouseId: String,
    val name: String,
    val address: Address,
    val operatingHours: OperatingHours,
    val usagePurpose: UsagePurpose,
)
