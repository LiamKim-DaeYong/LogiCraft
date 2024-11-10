package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.WarehouseMaintenanceUseCase
import com.logicraft.masterdata.application.port.out.warehouse.WarehouseMaintenancePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WarehouseMaintenanceService(
    private val warehouseMaintenancePort: WarehouseMaintenancePort,
) : WarehouseMaintenanceUseCase {
    override fun startMaintenance(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }

    override fun endMaintenance(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }
}
