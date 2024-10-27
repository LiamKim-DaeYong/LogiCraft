package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.ModifyWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.ModifyWarehouseUseCase
import com.masterdata.application.port.out.warehouse.ModifyWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service

@Service
class ModifyWarehouseService(
    private val modifyWarehousePort: ModifyWarehousePort
) : ModifyWarehouseUseCase {
    override fun modifyWarehouse(command: ModifyWarehouseCommand): Warehouse {
        TODO("Not yet implemented")
    }
}