package com.logicraft.masterdata.adapter.out.persistence.entity.warehouse

import com.logicraft.common.entity.AddressJpaEntity
import com.logicraft.common.enums.ActiveStatus
import com.logicraft.masterdata.domain.warehouse.enums.UsagePurpose
import com.logicraft.masterdata.domain.warehouse.enums.WarehouseType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "warehouse")
@Suppress("ktlint:standard:no-blank-line-in-list", "ktlint:standard:no-trailing-spaces")
class WarehouseJpaEntity(
    @Id
    @Column(name = "warehouse_id", nullable = false)
    val id: String? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Embedded
    var address: AddressJpaEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    var type: WarehouseType,

    @Embedded
    var operatingHours: OperatingHoursJpaEntity,

    @Enumerated(EnumType.STRING)
    @Column(name = "usage_purpose", nullable = false)
    var usagePurpose: UsagePurpose,

    @Enumerated(EnumType.STRING)
    @Column(name = "active_status", nullable = false)
    var activeStatus: ActiveStatus,
) {
    // ======= Business Logic Start ======= //
    fun update(
        name: String,
        address: AddressJpaEntity,
        operatingHours: OperatingHoursJpaEntity,
        usagePurpose: UsagePurpose,
    ) {
        this.name = name
        this.address = address
        this.operatingHours = operatingHours
        this.usagePurpose = usagePurpose
    }
    // ======= Business Logic End ======= //
}
