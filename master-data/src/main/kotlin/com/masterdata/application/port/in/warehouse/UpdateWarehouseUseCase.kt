package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.core.model.Address
import com.masterdata.domain.warehouse.OperatingHours
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.enums.UsagePurpose

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