package com.logicraft.masterdata.domain.location

import com.logicraft.masterdata.domain.location.policy.StoragePolicy

class Bin(
    override val id: LocationId,
    override val name: LocationName,
    val section: Section,
    override val storagePolicy: StoragePolicy,
) : Location
