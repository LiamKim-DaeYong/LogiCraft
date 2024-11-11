package com.logicraft.masterdata.domain.location

import com.logicraft.masterdata.domain.location.policy.StoragePolicy

class Section(
    override val id: LocationId,
    override val name: LocationName,
    val parentZone: Zone,
    override val storagePolicy: StoragePolicy,
) : Location {
    private val _locations: MutableList<Location> = mutableListOf()
    val locations: List<Location> get() = _locations

    // ======= Business Logic Start ======= //
    fun addLocation(location: Location) {
        _locations.add(location)
    }
    // ======= Business Logic End ======= //
}