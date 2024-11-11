package com.logicraft.masterdata.domain.location

import com.logicraft.masterdata.domain.location.policy.StoragePolicy

interface Location {
    val id: LocationId
    val name: LocationName
    val storagePolicy: StoragePolicy
}

@JvmInline
value class LocationId(val value: String)

@JvmInline
value class LocationName(val value: String)
