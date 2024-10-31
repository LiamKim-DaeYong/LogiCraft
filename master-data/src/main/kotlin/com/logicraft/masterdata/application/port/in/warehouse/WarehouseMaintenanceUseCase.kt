package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.masterdata.domain.warehouse.Warehouse

@UseCase
interface WarehouseMaintenanceUseCase {
    fun startMaintenance(warehouseId: String): Warehouse
    fun endMaintenance(warehouseId: String): Warehouse
}
