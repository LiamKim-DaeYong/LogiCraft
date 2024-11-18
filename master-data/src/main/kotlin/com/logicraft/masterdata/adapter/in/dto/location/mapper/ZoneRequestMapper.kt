package com.logicraft.masterdata.adapter.`in`.dto.location.mapper

import com.logicraft.masterdata.adapter.`in`.dto.location.request.CreateZoneRequest
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneCommand

fun CreateZoneRequest.toCreateZoneCommand(): CreateZoneCommand {
    return CreateZoneCommand(
        name = name,
        type = type,
        code = code,
        warehouseId = warehouseId,
    )
}
