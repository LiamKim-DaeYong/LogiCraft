package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

interface WarehouseStatusChangePort {
    fun activateWarehouse(warehouseId: WarehouseId): Warehouse
    fun deactivateWarehouse(warehouseId: WarehouseId): Warehouse
}
