package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.application.port.out.warehouse.ModifyWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class ModifyWarehouseAdapter(
) : ModifyWarehousePort {

    override fun modifyWarehouse(warehouseId: WarehouseId, updatedWarehouse: Warehouse): Warehouse {
        // JPA 수정 로직 구현 예정
        return updatedWarehouse
    }
}
