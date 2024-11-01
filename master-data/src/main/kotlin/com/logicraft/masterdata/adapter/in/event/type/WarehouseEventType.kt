package com.logicraft.masterdata.adapter.`in`.event.type

import com.logicraft.common.event.EventType

enum class WarehouseEventType : EventType {
    CREATE_WAREHOUSE {
        override val typeName = "CREATE_WAREHOUSE"
    },
    UPDATE_WAREHOUSE {
        override val typeName = "UPDATE_WAREHOUSE"
    }
}