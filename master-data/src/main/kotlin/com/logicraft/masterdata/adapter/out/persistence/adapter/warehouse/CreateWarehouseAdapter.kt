package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseJpaRepository
import com.logicraft.masterdata.application.port.out.warehouse.CreateWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class CreateWarehouseAdapter(
    private val warehouseJpaRepository: WarehouseJpaRepository
) : CreateWarehousePort {

    override fun createWarehouse(warehouse: Warehouse): Warehouse {
        val warehouseJpaEntity = com.logicraft.masterdata.adapter.out.persistence.mapper.WarehouseMapper.toJpaEntity(warehouse)
        val savedEntity = warehouseJpaRepository.save(warehouseJpaEntity)

        return com.logicraft.masterdata.adapter.out.persistence.mapper.WarehouseMapper.toDomainEntity(savedEntity)
    }
}