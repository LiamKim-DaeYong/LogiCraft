package com.logicraft.masterdata.application.port.out.warehouse

import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

interface WarehouseStatusChangePort {
    fun activateWarehouse(warehouseId: WarehouseId): Warehouse

    fun deactivateWarehouse(warehouseId: WarehouseId): Warehouse
}
