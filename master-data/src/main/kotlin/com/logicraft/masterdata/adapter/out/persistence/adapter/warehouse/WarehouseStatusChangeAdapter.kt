package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.application.port.out.warehouse.WarehouseStatusChangePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

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
