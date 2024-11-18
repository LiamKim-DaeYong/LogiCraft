package com.logicraft.masterdata.adapter.out.persistence.mapper.warehouse

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.common.model.Address
import com.logicraft.generated.jooq.tables.records.WarehouseRecord
import com.logicraft.masterdata.domain.warehouse.OperatingHours
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import com.logicraft.masterdata.domain.warehouse.WarehouseName
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType

fun WarehouseRecord.toDomainEntity(): Warehouse {
    return Warehouse(
        id = WarehouseId(warehouseId),
        name = WarehouseName(name),
        type = WarehouseType.valueOf(type),
        address =
            Address(
                city = city,
                street = street,
                postalCode = postalCode,
                country = country,
                detailAddress = detailAddress,
                provinceOrState = provinceOrState,
            ),
        operatingHours =
            OperatingHours(
                openingTime = openingTime,
                closingTime = closingTime,
            ),
        usagePurpose = UsagePurpose.valueOf(usagePurpose),
        activeStatus = ActiveStatus.valueOf(status),
    )
}
