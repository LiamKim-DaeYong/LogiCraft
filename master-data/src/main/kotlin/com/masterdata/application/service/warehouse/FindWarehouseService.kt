package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import com.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service

@Service
class FindWarehouseService(

) : FindWarehouseUseCase {
    override fun findWarehouse(command: FindWarehouseCommand): Warehouse {
        TODO("Not yet implemented")
    }
}
