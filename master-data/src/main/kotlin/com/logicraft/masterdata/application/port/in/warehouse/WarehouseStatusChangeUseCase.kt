package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.masterdata.domain.warehouse.Warehouse

@UseCase
interface WarehouseStatusChangeUseCase {

    fun activateWarehouse(warehouseId: String): Warehouse
    fun deactivateWarehouse(warehouseId: String): Warehouse
}
