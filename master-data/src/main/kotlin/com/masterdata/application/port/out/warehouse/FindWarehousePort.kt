package com.masterdata.application.port.out.warehouse

import com.masterdata.domain.warehouse.Warehouse

interface FindWarehousePort {
    fun findWarehouseById(warehouseId: String): Warehouse?
}
