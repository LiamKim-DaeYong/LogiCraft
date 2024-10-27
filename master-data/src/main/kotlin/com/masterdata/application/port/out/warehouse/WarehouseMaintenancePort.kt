package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

interface WarehouseMaintenancePort {
    fun startMaintenance(warehouseId: WarehouseId): Warehouse
    fun endMaintenance(warehouseId: WarehouseId): Warehouse
}
