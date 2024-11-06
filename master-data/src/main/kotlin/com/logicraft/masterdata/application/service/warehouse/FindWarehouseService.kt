package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseQuery
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import com.logicraft.masterdata.application.port.out.warehouse.FindWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import org.springframework.stereotype.Service

@Service
class FindWarehouseService(
    private val findWarehousePort: FindWarehousePort
) : FindWarehouseUseCase {

    override fun findWarehouse(query: FindWarehouseQuery): Warehouse {
        return findWarehousePort.findWarehouseById(WarehouseId(query.warehouseId))
            ?: throw IllegalArgumentException("Warehouse not found")
    }
}
