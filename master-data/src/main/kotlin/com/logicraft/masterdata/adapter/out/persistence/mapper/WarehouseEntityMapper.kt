package com.logicraft.masterdata.adapter.out.persistence.mapper

import com.logicraft.common.mapper.toDomainEntity
import com.logicraft.common.mapper.toJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.OperatingHoursJpaEntity
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import com.logicraft.masterdata.domain.warehouse.WarehouseName

fun Warehouse.toJpaEntity(): WarehouseJpaEntity {
    return WarehouseJpaEntity(
        id = id.value,
        name = name.value,
        address = address.toJpaEntity(),
        type = type,
        operatingHours = OperatingHoursJpaEntity(
            openingTime = operatingHours.openingTime,
            closingTime = operatingHours.closingTime
        ),
        usagePurpose = usagePurpose,
        status = status
    )
}

fun WarehouseJpaEntity.toDomainEntity(): Warehouse {
    return Warehouse(
        id = WarehouseId(id.toString()),
        name = WarehouseName(name),
        address = address.toDomainEntity(),
        type = type,
        operatingHours = OperatingHours(
            openingTime = operatingHours.openingTime,
            closingTime = operatingHours.closingTime
        ),
        usagePurpose = usagePurpose,
        status = status
    )
}
