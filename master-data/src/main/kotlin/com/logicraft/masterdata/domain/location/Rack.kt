package com.logicraft.masterdata.domain.location

class Rack(
    val id: RackId,
    val code: RackCode,
    val aisle: Aisle,
) {

    private val _bins: MutableList<Bin> = mutableListOf()
    val bins: List<Bin>
        get() = _bins

    // ======= Business Logic Start ======= //
    fun addBin(bin: Bin) {
        _bins.add(bin)
    }
    // ======= Business Logic End ======= //
}

@JvmInline
value class RackId(
    val value: String,
)

@JvmInline
value class RackCode(
    val value: String,
)
