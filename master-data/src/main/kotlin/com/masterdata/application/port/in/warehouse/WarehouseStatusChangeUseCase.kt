package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.masterdata.domain.warehouse.Warehouse

@UseCase
interface WarehouseStatusChangeUseCase {
    fun activateWarehouse(warehouseId: String): Warehouse
    fun deactivateWarehouse(warehouseId: String): Warehouse
}
