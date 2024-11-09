package com.logicraft.masterdata.application.port.`in`.warehouse

import com.logicraft.common.annotations.UseCase
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

@UseCase
interface FindAllWarehousesUseCase {

    fun findAllWarehouses(): List<Warehouse>
}
