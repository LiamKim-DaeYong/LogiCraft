package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.common.exception.DomainException
import com.logicraft.common.exception.HttpException
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseQuery
import com.logicraft.masterdata.application.port.`in`.warehouse.FindWarehouseUseCase
import com.logicraft.masterdata.application.port.out.warehouse.FindWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FindWarehouseService(
    private val findWarehousePort: FindWarehousePort
) : FindWarehouseUseCase {

    override fun findWarehouse(query: FindWarehouseQuery): Warehouse {
        return findWarehousePort.findWarehouseById(WarehouseId(query.warehouseId))
            ?: throw DomainException.NotFoundException(Warehouse::class, query.warehouseId)
    }
}
