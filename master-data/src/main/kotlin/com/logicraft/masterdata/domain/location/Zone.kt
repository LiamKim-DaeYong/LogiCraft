package com.logicraft.masterdata.domain.location

import com.logicraft.masterdata.domain.location.enums.ZoneStatus
import com.logicraft.masterdata.domain.location.enums.ZoneType

class Zone(
    val id: ZoneId,
    val code: ZoneCode,
    val name: ZoneName,
    val type: ZoneType,
    val status: ZoneStatus,
) {
    private val _aisles: MutableList<Aisle> = mutableListOf()
    val aisles: List<Aisle>
        get() = _aisles

    // ======= Business Logic Start ======= //
    fun addAisle(aisle: Aisle) {
        _aisles.add(aisle)
    }
    // ======= Business Logic End ======= //
}

@JvmInline
value class ZoneId(
    val value: String,
)

@JvmInline
value class ZoneCode(
    val value: String,
)

@JvmInline
value class ZoneName(
    val value: String,
)
