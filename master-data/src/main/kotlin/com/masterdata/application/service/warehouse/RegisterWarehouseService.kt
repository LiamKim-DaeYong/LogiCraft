package com.masterdata.application.service.warehouse

import com.core.enums.ActiveStatus
import com.masterdata.application.port.`in`.warehouse.RegisterWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.RegisterWarehouseUseCase
import com.masterdata.application.port.out.warehouse.RegisterWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId
import com.masterdata.domain.warehouse.WarehouseName
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterWarehouseService(
    private val registerWarehousePort: RegisterWarehousePort
) : RegisterWarehouseUseCase {

    override fun registerWarehouse(command: RegisterWarehouseCommand): Warehouse {
        val warehouse = Warehouse(
            id = WarehouseId(UUID.randomUUID().toString()),
            name = WarehouseName(command.name),
            type = command.type,
            address = command.address,
            operatingHours = command.operatingHours,
            usagePurpose = command.usagePurpose,
            status = ActiveStatus.ACTIVE
        )

        return registerWarehousePort.registerWarehouse(warehouse)
    }
}
