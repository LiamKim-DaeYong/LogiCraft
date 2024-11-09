package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.common.exception.DomainException
import com.logicraft.common.mapper.toJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.OperatingHoursJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.mapper.toDomainEntity
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseCommandRepository
import com.logicraft.masterdata.application.port.out.warehouse.UpdateWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class UpdateWarehouseAdapter(
    private val warehouseCommandRepository: WarehouseCommandRepository
) : UpdateWarehousePort {

    override fun updateWarehouse(warehouseId: WarehouseId, updatedWarehouse: Warehouse): Warehouse {
        val existingWarehouseEntity = warehouseCommandRepository.findById(warehouseId.value)
            .orElseThrow { DomainException.NotFoundException(Warehouse::class, warehouseId.value) }

        existingWarehouseEntity.update(
            name = updatedWarehouse.name.value,
            address = updatedWarehouse.address.toJpaEntity(),
            operatingHours = OperatingHoursJpaEntity(
                updatedWarehouse.operatingHours.openingTime,
                updatedWarehouse.operatingHours.closingTime
            ),
            usagePurpose = updatedWarehouse.usagePurpose
        )

        return existingWarehouseEntity.toDomainEntity()
    }
}
