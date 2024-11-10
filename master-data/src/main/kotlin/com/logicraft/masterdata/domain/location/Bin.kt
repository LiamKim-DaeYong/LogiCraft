package com.logicraft.masterdata.domain.location

class Bin(
    val id: BinId,
    val code: BinCode,
    val rack: Rack,
) {

    private var _inventoryCount: Int = 0
    val inventoryCount: Int
        get() = _inventoryCount

    // ======= Business Logic Start ======= //
    fun addInventory(count: Int) {
        if (count > 0) _inventoryCount += count
    }

    fun removeInventory(count: Int) {
        if (count in 1.._inventoryCount) _inventoryCount -= count
    }
    // ======= Business Logic End ======= //
}

@JvmInline
value class BinId(
    val value: String,
)

@JvmInline
value class BinCode(
    val value: String,
)
