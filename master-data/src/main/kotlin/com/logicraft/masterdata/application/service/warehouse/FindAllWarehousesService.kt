package com.logicraft.masterdata.application.service.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.FindAllWarehousesUseCase
import com.logicraft.masterdata.application.port.out.warehouse.FindAllWarehousesPort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FindAllWarehousesService(
    private val findAllWarehousesPort: FindAllWarehousesPort
) : FindAllWarehousesUseCase {

    override fun findAllWarehouses(): List<Warehouse> {
        return findAllWarehousesPort.findAllWarehouses()
    }
}
