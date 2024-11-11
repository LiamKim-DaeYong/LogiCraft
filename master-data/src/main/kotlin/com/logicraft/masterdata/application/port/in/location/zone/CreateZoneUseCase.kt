package com.logicraft.masterdata.application.port.`in`.location.zone

import com.logicraft.common.annotations.UseCase
import com.logicraft.masterdata.domain.location.Zone
import com.logicraft.masterdata.domain.location.enums.ZoneType

@UseCase
interface CreateZoneUseCase {
    fun createZone(command: CreateZoneCommand): Zone
}

data class CreateZoneCommand(
    val name: String,
    val warehouseId: String,
    val code: String,
    val type: ZoneType,
)
