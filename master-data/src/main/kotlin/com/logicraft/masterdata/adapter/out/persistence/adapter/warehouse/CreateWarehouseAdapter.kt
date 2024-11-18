package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.adapter.out.persistence.mapper.warehouse.toDomainEntity
import com.logicraft.masterdata.adapter.out.persistence.mapper.warehouse.toJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseCommandRepository
import com.logicraft.masterdata.application.port.out.warehouse.CreateWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class CreateWarehouseAdapter(
    private val warehouseCommandRepository: WarehouseCommandRepository,
) : CreateWarehousePort {
    override fun createWarehouse(warehouse: Warehouse): Warehouse {
        val warehouseJpaEntity = warehouse.toJpaEntity()
        val savedEntity = warehouseCommandRepository.save(warehouseJpaEntity)

        return savedEntity.toDomainEntity()
    }
}
