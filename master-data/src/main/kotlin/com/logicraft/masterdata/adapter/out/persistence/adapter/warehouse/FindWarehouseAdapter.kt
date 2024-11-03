package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.adapter.out.persistence.mapper.WarehouseMapper
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseJpaRepository
import com.logicraft.masterdata.application.port.out.warehouse.FindWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

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
