package com.logicraft.masterdata.adapter.out.persistence.entity.location

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity
import com.logicraft.masterdata.domain.location.ZoneCode
import com.logicraft.masterdata.domain.location.enums.ZoneType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "zone")
class ZoneJpaEntity(
    id: String,
    name: String,
    parent: LocationJpaEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    val warehouse: WarehouseJpaEntity,

    @Column(name = "zone_code", nullable = false)
    val code: ZoneCode,

    @Column(name = "zone_type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: ZoneType,

    @Column(name = "location_active_status", nullable = false)
    @Enumerated(EnumType.STRING)
    val activeStatus: ActiveStatus
) : LocationJpaEntity(id, name, parent)
