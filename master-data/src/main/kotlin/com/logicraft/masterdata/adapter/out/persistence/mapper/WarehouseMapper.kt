package com.logicraft.masterdata.adapter.out.persistence.mapper

import com.logicraft.common.mapper.AddressMapper
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import com.logicraft.masterdata.domain.warehouse.WarehouseName

object WarehouseMapper {
    fun toJpaEntity(warehouse: Warehouse): com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity {
        return com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity(
            id = warehouse.id.value,
            name = warehouse.name.value,
            address = AddressMapper.toJpaEntity(warehouse.address),
            type = warehouse.type,
            operatingHours = com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.OperatingHoursJpaEntity(
                openingTime = warehouse.operatingHours.openingTime,
                closingTime = warehouse.operatingHours.closingTime
            ),
            usagePurpose = warehouse.usagePurpose,
            status = warehouse.status
        )
    }

    fun toDomainEntity(warehouseJpaEntity: com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity): Warehouse {
        return Warehouse(
            id = WarehouseId(warehouseJpaEntity.id.toString()),
            name = WarehouseName(warehouseJpaEntity.name),
            address = AddressMapper.toDomainEntity(warehouseJpaEntity.address),
            type = warehouseJpaEntity.type,
            operatingHours = OperatingHours(
                openingTime = warehouseJpaEntity.operatingHours.openingTime,
                closingTime = warehouseJpaEntity.operatingHours.closingTime
            ),
            usagePurpose = warehouseJpaEntity.usagePurpose,
            status = warehouseJpaEntity.status
        )
    }
}