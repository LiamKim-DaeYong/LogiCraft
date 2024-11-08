package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.WarehouseStatusChangeUseCase
import com.logicraft.masterdata.application.port.out.warehouse.WarehouseStatusChangePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
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