package com.masterdata.adapter.out.persistence.adapter.warehouse

import com.core.annotations.PersistenceAdapter
import com.masterdata.adapter.out.persistence.mapper.WarehouseMapper
import com.masterdata.adapter.out.persistence.repository.warehouse.WarehouseJpaRepository
import com.masterdata.application.port.out.warehouse.CreateWarehousePort
import com.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class CreateWarehouseAdapter(
    private val warehouseJpaRepository: WarehouseJpaRepository
) : CreateWarehousePort {

    override fun createWarehouse(warehouse: Warehouse): Warehouse {
        val warehouseJpaEntity = WarehouseMapper.toJpaEntity(warehouse)
        val savedEntity = warehouseJpaRepository.save(warehouseJpaEntity)

        return WarehouseMapper.toDomainEntity(savedEntity)
    }
}