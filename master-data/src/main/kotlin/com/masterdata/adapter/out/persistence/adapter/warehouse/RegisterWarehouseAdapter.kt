package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.application.port.out.warehouse.RegisterWarehousePort
import com.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class RegisterWarehouseAdapter() : RegisterWarehousePort {

    override fun registerWarehouse(warehouse: Warehouse): Warehouse {
        // JPA 저장 로직 구현 예정
        return warehouse
    }
}