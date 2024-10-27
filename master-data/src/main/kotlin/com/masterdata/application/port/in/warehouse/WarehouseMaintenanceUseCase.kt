package com.masterdata.application.port.`in`.warehouse

import com.core.annotations.UseCase
import com.masterdata.domain.warehouse.Warehouse

@UseCase
interface WarehouseMaintenanceUseCase {
    fun startMaintenance(warehouseId: String): Warehouse
    fun endMaintenance(warehouseId: String): Warehouse
}
