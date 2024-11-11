package com.logicraft.masterdata.application.port.out.location.zone

import com.logicraft.masterdata.domain.location.Zone

interface CreateZonePort {
    fun createZone(zone: Zone): Zone
}
