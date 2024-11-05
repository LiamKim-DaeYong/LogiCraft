package com.logicraft.masterdata.application.port.out.warehouse

import com.logicraft.masterdata.domain.warehouse.Warehouse

interface FindAllWarehousesPort {
    fun findAllWarehouses(): List<Warehouse>
}
