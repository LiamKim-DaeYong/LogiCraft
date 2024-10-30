package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import com.masterdata.application.port.out.warehouse.FindWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId
import org.springframework.stereotype.Service

@Service
class FindWarehouseService(
    private val findWarehousePort: FindWarehousePort
) : FindWarehouseUseCase {

    override fun findWarehouse(command: FindWarehouseCommand): Warehouse {
        return findWarehousePort.findWarehouseById(WarehouseId(command.warehouseId))
            ?: throw IllegalArgumentException("Warehouse not found")
    }
}
