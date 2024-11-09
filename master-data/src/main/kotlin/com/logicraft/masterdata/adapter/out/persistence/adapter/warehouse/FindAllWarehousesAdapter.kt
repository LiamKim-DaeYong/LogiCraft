package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.adapter.out.persistence.mapper.toDomainEntity
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseQueryRepository
import com.logicraft.masterdata.application.port.out.warehouse.FindAllWarehousesPort
import com.logicraft.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class FindAllWarehousesAdapter(
    private val warehouseQueryRepository: WarehouseQueryRepository
) : FindAllWarehousesPort {

    override fun findAllWarehouses(): List<Warehouse> {
        return warehouseQueryRepository.findAll()
            .map { it.toDomainEntity() }
    }
}
