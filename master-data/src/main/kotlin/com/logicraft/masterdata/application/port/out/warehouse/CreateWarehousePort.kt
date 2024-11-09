package com.logicraft.masterdata.application.port.out.warehouse

import com.logicraft.masterdata.domain.warehouse.Warehouse

interface CreateWarehousePort {

    fun createWarehouse(warehouse: Warehouse): Warehouse
}
