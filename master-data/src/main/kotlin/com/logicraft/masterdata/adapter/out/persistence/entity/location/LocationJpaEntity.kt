package com.logicraft.masterdata.adapter.out.persistence.entity.location

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "location")
abstract class LocationJpaEntity(
    @Id
    @Column(name = "location_id", nullable = false)
    open val id: String,

    @Column(name = "location_name", nullable = false)
    open var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    open var parent: LocationJpaEntity? = null,
)
