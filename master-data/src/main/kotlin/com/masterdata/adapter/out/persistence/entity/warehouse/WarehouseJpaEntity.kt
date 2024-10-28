package com.masterdata.adapter.out.persistence.entity.warehouse

import com.core.entity.AddressJpaEntity
import com.core.enums.ActiveStatus
import com.masterdata.domain.warehouse.enums.UsagePurpose
import com.masterdata.domain.warehouse.enums.WarehouseType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "warehouse")
class WarehouseJpaEntity(

    @Id
    @Column(name = "warehouse_id")
    val id: String? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @Embedded
    val address: AddressJpaEntity,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: WarehouseType,

    @Embedded
    val operatingHours: OperatingHoursJpaEntity,

    @Column(name = "usage_purpose", nullable = false)
    @Enumerated(EnumType.STRING)
    val usagePurpose: UsagePurpose,

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    val status: ActiveStatus
)