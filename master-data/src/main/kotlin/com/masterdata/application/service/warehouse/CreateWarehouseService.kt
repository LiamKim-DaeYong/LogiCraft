package com.masterdata.application.service.warehouse

import com.core.enums.ActiveStatus
import com.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.CreateWarehouseUseCase
import com.masterdata.application.port.out.warehouse.CreateWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId
import com.masterdata.domain.warehouse.WarehouseName
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateWarehouseService(
    private val createWarehousePort: CreateWarehousePort
) : CreateWarehouseUseCase {

    override fun createWarehouse(command: CreateWarehouseCommand): Warehouse {
        val warehouse = Warehouse(
            id = WarehouseId(UUID.randomUUID().toString()),
            name = WarehouseName(command.name),
            type = command.type,
            address = command.address,
            operatingHours = command.operatingHours,
            usagePurpose = command.usagePurpose,
            status = ActiveStatus.ACTIVE
        )

        return createWarehousePort.createWarehouse(warehouse)
    }
}
