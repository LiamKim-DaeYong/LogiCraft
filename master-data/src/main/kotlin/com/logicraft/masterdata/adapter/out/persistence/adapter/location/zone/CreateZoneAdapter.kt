package com.logicraft.masterdata.adapter.out.persistence.adapter.location.zone

import com.logicraft.common.annotations.PersistenceAdapter
import com.logicraft.masterdata.application.port.out.location.zone.CreateZonePort
import com.logicraft.masterdata.domain.location.Zone

@PersistenceAdapter
class CreateZoneAdapter() : CreateZonePort {
    override fun createZone(zone: Zone): Zone {
        TODO("Not yet implemented")
    }
}
