package com.logicraft.masterdata.adapter.`in`.event.type

import com.logicraft.common.event.BasicEventAction
import com.logicraft.common.event.EventAction
import com.logicraft.common.event.EventCategory
import com.logicraft.common.event.EventType

sealed class WarehouseEventType(
    override val typeName: String,
    val category: EventCategory,
    val action: EventAction,
) : EventType {

    data object FindAllWarehouses : WarehouseEventType(
        "FIND_ALL_WAREHOUSES",
        EventCategory.DataRetrieval,
        BasicEventAction.Query
    )

    data object FindWarehouse :
        WarehouseEventType("FIND_WAREHOUSE", EventCategory.DataRetrieval, BasicEventAction.Query)

    data object CreateWarehouse : WarehouseEventType(
        "CREATE_WAREHOUSE",
        EventCategory.DataModification,
        BasicEventAction.Command.Create
    )

    data object UpdateWarehouse : WarehouseEventType(
        "UPDATE_WAREHOUSE",
        EventCategory.DataModification,
        BasicEventAction.Command.Update
    )
}
