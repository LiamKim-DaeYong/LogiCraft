package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.application.port.out.warehouse.WarehouseStatusChangePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class WarehouseStatusChangeAdapter() : WarehouseStatusChangePort {

    override fun activateWarehouse(warehouseId: WarehouseId): Warehouse {
        // JPA 활성화 로직 구현 예정
        TODO()
    }

    override fun deactivateWarehouse(warehouseId: WarehouseId): Warehouse {
        // JPA 비활성화 로직 구현 예정
        TODO()
    }
}
