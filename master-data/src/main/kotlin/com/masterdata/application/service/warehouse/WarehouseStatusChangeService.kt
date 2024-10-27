package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.WarehouseStatusChangeUseCase
import com.masterdata.application.port.out.warehouse.WarehouseStatusChangePort
import com.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service

@Service
class WarehouseStatusChangeService(
    private val warehouseStatusChangePort: WarehouseStatusChangePort
): WarehouseStatusChangeUseCase {
    override fun activateWarehouse(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }

    override fun deactivateWarehouse(warehouseId: String): Warehouse {
        TODO("Not yet implemented")
    }
}