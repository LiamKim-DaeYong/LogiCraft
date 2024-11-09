package com.logicraft.masterdata.application.port.out.warehouse

import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

interface WarehouseMaintenancePort {

    fun startMaintenance(warehouseId: WarehouseId): Warehouse
    fun endMaintenance(warehouseId: WarehouseId): Warehouse
}
