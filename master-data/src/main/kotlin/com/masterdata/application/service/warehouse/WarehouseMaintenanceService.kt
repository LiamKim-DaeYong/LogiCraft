package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.WarehouseMaintenanceUseCase
import com.masterdata.application.port.out.warehouse.WarehouseMaintenancePort
import com.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service

@Service
class WarehouseMaintenanceService(
    private val warehouseMaintenancePort: WarehouseMaintenancePort
): WarehouseMaintenanceUseCase {
    override fun startMaintenance(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }

    override fun endMaintenance(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }
}