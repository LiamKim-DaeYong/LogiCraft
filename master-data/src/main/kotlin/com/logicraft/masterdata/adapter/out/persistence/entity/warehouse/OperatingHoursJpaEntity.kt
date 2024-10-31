package com.logicraft.masterdata.adapter.out.persistence.entity.warehouse

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.LocalTime

@Embeddable
data class OperatingHoursJpaEntity(
    @Column(name = "opening_time", nullable = false)
    val openingTime: LocalTime = LocalTime.MIN,

    @Column(name = "closing_time", nullable = false)
    val closingTime: LocalTime = LocalTime.MAX
)