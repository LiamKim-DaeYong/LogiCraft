package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.masterdata.domain.warehouse.Warehouse

@UseCase
interface FindWarehouseUseCase {
    fun findWarehouse(command: FindWarehouseCommand): Warehouse
}

data class FindWarehouseCommand(
    val warehouseId: String,
)