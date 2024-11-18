package com.logicraft.masterdata.adapter.out.persistence.mapper.location

import com.logicraft.masterdata.adapter.out.persistence.entity.location.ZoneJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity
import com.logicraft.masterdata.domain.location.LocationId
import com.logicraft.masterdata.domain.location.LocationName
import com.logicraft.masterdata.domain.location.Zone
import com.logicraft.masterdata.domain.warehouse.WarehouseId

fun Zone.toJpaEntity(warehouseJpaEntity: WarehouseJpaEntity): ZoneJpaEntity {
    return ZoneJpaEntity(
        id = id.value,
        name = name.value,
        warehouse = warehouseJpaEntity,
        code = code,
        type = type,
        activeStatus = activeStatus
    )
}

fun ZoneJpaEntity.toDomainEntity(): Zone {
    return Zone(
        id = LocationId(id),
        name = LocationName(name),
        warehouseId = WarehouseId(warehouse.id),
        code = code,
        type = type,
        activeStatus = activeStatus,
    )
}
