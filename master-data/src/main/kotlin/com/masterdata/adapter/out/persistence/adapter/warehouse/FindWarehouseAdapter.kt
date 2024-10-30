package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.adapter.out.persistence.mapper.WarehouseMapper
import com.masterdata.adapter.out.persistence.repository.warehouse.WarehouseJpaRepository
import com.masterdata.application.port.out.warehouse.FindWarehousePort
import com.masterdata.domain.warehouse.Warehouse
import com.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class FindWarehouseAdapter(
    private val warehouseJpaRepository: WarehouseJpaRepository,
) : FindWarehousePort {

    override fun findWarehouseById(warehouseId: WarehouseId): Warehouse? {
        return warehouseJpaRepository.findById(warehouseId.value)
            .map { WarehouseMapper.toDomainEntity(it) }
            .orElse(null)
    }
}
