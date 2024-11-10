package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.masterdata.domain.warehouse.Warehouse

@UseCase
interface FindWarehouseUseCase {
    fun findWarehouse(query: FindWarehouseQuery): Warehouse
}

data class FindWarehouseQuery(
    val warehouseId: String,
)
