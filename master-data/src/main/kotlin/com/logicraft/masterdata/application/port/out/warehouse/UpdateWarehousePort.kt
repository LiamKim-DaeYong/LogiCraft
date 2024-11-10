package com.logicraft.masterdata.application.port.out.warehouse

import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

interface UpdateWarehousePort {
    fun updateWarehouse(
        warehouseId: WarehouseId,
        updatedWarehouse: Warehouse,
    ): Warehouse
}
