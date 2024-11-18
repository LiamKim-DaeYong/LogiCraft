package com.logicraft.masterdata.adapter.`in`.event.type

import com.logicraft.common.event.BasicEventAction
import com.logicraft.common.event.EventAction
import com.logicraft.common.event.EventCategory
import com.logicraft.common.event.EventType

sealed class ZoneEventType(
    override val typeName: String,
    val category: EventCategory,
    val action: EventAction,
) : EventType {
    data object CreateZone : ZoneEventType(
        "CREATE_ZONE",
        EventCategory.DataModification,
        BasicEventAction.Command.Create,
    )
}
