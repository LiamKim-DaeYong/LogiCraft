package com.logicraft.masterdata.adapter.`in`.dto.location.mapper

import com.logicraft.masterdata.adapter.`in`.dto.location.response.CreateZoneResponse
import com.logicraft.masterdata.domain.location.Zone

fun Zone.toCreateZoneResponse(): CreateZoneResponse {
    return CreateZoneResponse(id.value)
}
