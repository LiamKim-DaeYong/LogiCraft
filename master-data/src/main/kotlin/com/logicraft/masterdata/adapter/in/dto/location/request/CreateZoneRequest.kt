package com.logicraft.masterdata.adapter.`in`.dto.location.request

import com.logicraft.masterdata.domain.location.enums.ZoneType

data class CreateZoneRequest(
    val warehouseId: String,
    val name: String,
    val code: String,
    val type: ZoneType,
)
