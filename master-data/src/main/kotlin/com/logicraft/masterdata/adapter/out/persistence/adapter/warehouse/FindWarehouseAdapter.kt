package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.adapter.out.persistence.mapper.toDomainEntity
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseQueryRepository
import com.logicraft.masterdata.application.port.out.warehouse.FindWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class FindWarehouseAdapter(
    private val warehouseQueryRepository: WarehouseQueryRepository
) : FindWarehousePort {

    override fun findWarehouseById(warehouseId: WarehouseId): Warehouse? {
        return warehouseQueryRepository.findById(warehouseId.value)?.toDomainEntity()
    }
}
