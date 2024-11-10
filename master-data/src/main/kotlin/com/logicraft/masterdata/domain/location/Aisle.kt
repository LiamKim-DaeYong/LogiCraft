package com.logicraft.masterdata.domain.location

class Aisle(
    val id: AisleId,
    val code: AisleCode,
    val zone: Zone,
) {

    private val _racks: MutableList<Rack> = mutableListOf()
    val racks: List<Rack>
        get() = _racks

    // ======= Business Logic Start ======= //
    fun addRack(rack: Rack) {
        _racks.add(rack)
    }
    // ======= Business Logic End ======= //
}

@JvmInline
value class AisleId(val value: String)

@JvmInline
value class AisleCode(val value: String)
