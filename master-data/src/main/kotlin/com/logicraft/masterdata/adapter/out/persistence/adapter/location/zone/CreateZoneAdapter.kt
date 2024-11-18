package com.logicraft.masterdata.adapter.out.persistence.adapter.location.zone

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.common.exception.DomainException
import com.logicraft.masterdata.adapter.out.persistence.mapper.location.toDomainEntity
import com.logicraft.masterdata.adapter.out.persistence.mapper.location.toJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.repository.location.LocationCommandRepository
import com.logicraft.masterdata.adapter.out.persistence.repository.warehouse.WarehouseCommandRepository
import com.logicraft.masterdata.application.port.out.location.zone.CreateZonePort
import com.logicraft.masterdata.domain.location.Zone
import com.logicraft.masterdata.domain.warehouse.Warehouse

@PersistenceAdapter
class CreateZoneAdapter(
    private val locationCommandRepository: LocationCommandRepository,
    private val warehouseCommandRepository: WarehouseCommandRepository
) : CreateZonePort {
    override fun createZone(zone: Zone): Zone {
        val warehouseJpaEntity =  warehouseCommandRepository.findById(zone.warehouseId.value)
            .orElseThrow { DomainException.NotFoundException(Warehouse::class, zone.warehouseId.value) }

        val zoneJpaEntity = zone.toJpaEntity(warehouseJpaEntity)
        val savedEntity = locationCommandRepository.save(zoneJpaEntity)

        return savedEntity.toDomainEntity()
    }
}
