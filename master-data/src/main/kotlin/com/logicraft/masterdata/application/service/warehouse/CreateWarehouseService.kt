package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseCommand
import com.logicraft.masterdata.application.port.`in`.warehouse.CreateWarehouseUseCase
import com.logicraft.masterdata.application.port.out.warehouse.CreateWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import com.logicraft.masterdata.domain.warehouse.WarehouseName
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
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
