package com.logicraft.masterdata.adapter.out.persistence.adapter.warehouse

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.common.mapper.AddressMapper
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.OperatingHoursJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.mapper.WarehouseMapper
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseJpaRepository
import com.logicraft.masterdata.application.port.out.warehouse.UpdateWarehousePort
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId

@PersistenceAdapter
class UpdateWarehouseAdapter(
    private val warehouseJpaRepository: WarehouseJpaRepository
) : UpdateWarehousePort {

    override fun updateWarehouse(warehouseId: WarehouseId, updatedWarehouse: Warehouse): Warehouse {
        val existingWarehouseEntity = warehouseJpaRepository.findById(warehouseId.value)
            .orElseThrow { IllegalArgumentException("Warehouse with ID $warehouseId not found") }

        existingWarehouseEntity.update(
            name = updatedWarehouse.name.value,
            address = AddressMapper.toJpaEntity(updatedWarehouse.address),
            operatingHours = OperatingHoursJpaEntity(
                updatedWarehouse.operatingHours.openingTime,
                updatedWarehouse.operatingHours.closingTime
            ),
            usagePurpose = updatedWarehouse.usagePurpose,
            type = updatedWarehouse.type
        )

        return WarehouseMapper.toDomainEntity(existingWarehouseEntity)
    }
}
