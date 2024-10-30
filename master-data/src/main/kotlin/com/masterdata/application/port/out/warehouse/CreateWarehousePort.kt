package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse

interface CreateWarehousePort {
    fun createWarehouse(warehouse: Warehouse): Warehouse
}
