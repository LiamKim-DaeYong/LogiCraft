package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse

interface RegisterWarehousePort {
    fun registerWarehouse(warehouse: Warehouse): Warehouse
}
