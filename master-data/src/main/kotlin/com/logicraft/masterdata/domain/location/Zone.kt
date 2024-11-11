package com.logicraft.masterdata.domain.location

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.common.exception.DomainException
import com.logicraft.masterdata.domain.location.enums.ZoneType
import com.logicraft.masterdata.domain.location.policy.StoragePolicy
import com.logicraft.masterdata.domain.warehouse.WarehouseId

class Zone(
    override val id: LocationId,
    override val name: LocationName,
    val warehouseId: WarehouseId,
    val code: ZoneCode,
    val type: ZoneType,
    val activeStatus: ActiveStatus,
    override val storagePolicy: StoragePolicy,
) : Location {
    private val _locations: MutableList<Location> = mutableListOf()
    val locations: List<Location> get() = _locations

    // ======= Business Logic Start ======= //
    fun addLocation(location: Location) {
        if (location is Zone) {
            throw DomainException.InvalidAction(
                entityClass = Zone::class,
                action = "Adding a Zone to another Zone",
            )
        }
        _locations.add(location)
    }
    // ======= Business Logic End ======= //
}

@JvmInline
value class ZoneCode(val value: String)
