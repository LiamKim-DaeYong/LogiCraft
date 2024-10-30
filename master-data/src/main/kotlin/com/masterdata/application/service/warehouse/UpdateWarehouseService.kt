package com.masterdata.application.service.warehouse

import com.masterdata.application.port.`in`.warehouse.FindWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import com.masterdata.application.port.`in`.warehouse.UpdateWarehouseCommand
import com.masterdata.application.port.`in`.warehouse.UpdateWarehouseUseCase
import com.masterdata.application.port.out.warehouse.UpdateWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseName
import org.springframework.stereotype.Service

@Service
class UpdateWarehouseService(
    private val findWarehouseUseCase: FindWarehouseUseCase,
    private val updateWarehousePort: UpdateWarehousePort,
) : UpdateWarehouseUseCase {
    override fun updateWarehouse(command: UpdateWarehouseCommand): Warehouse {
        val warehouse = findWarehouseUseCase.findWarehouse(FindWarehouseCommand(command.warehouseId))

        val updatedWarehouse = Warehouse(
            id = warehouse.id,
            name = WarehouseName(command.name),
            type = warehouse.type,
            address = command.address,
            operatingHours = command.operatingHours,
            usagePurpose = command.usagePurpose,
            status = warehouse.status
        )

        return updateWarehousePort.updateWarehouse(
            warehouseId = updatedWarehouse.id,
            updatedWarehouse = updatedWarehouse
        )
    }
}
