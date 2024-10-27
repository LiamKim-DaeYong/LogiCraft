package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.application.port.out.warehouse.WarehouseMaintenancePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class WarehouseMaintenanceAdapter() : WarehouseMaintenancePort {

    override fun startMaintenance(warehouseId: WarehouseId): Warehouse {
        // JPA 유지보수 시작 로직 구현 예정
        TODO()
    }

    override fun endMaintenance(warehouseId: WarehouseId): Warehouse {
        // JPA 유지보수 종료 로직 구현 예정
        TODO()
    }
}
