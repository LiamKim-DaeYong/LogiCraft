package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.core.model.Address
import com.masterdata.domain.warehouse.OperatingHours
import com.masterdata.domain.warehouse.Warehouse

@UseCase
interface ModifyWarehouseUseCase {
    fun modifyWarehouse(command: ModifyWarehouseCommand): Warehouse
}

data class ModifyWarehouseCommand(
    val warehouseId: String,
    val name: String,
    val address: Address,
    val operatingHours: OperatingHours,
)