package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

interface ModifyWarehousePort {
    fun modifyWarehouse(warehouseId: WarehouseId, updatedWarehouse: Warehouse): Warehouse
}
