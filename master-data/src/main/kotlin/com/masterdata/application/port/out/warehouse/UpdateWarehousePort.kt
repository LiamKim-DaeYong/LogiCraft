package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

interface UpdateWarehousePort {
    fun updateWarehouse(warehouseId: WarehouseId, updatedWarehouse: Warehouse): Warehouse
}
