package com.logicraft.masterdata.adapter.`in`.event.type

import com.logicraft.common.event.EventType

enum class WarehouseEventType : EventType {
    FIND_ALL_WAREHOUSES {
        override val typeName = "FIND_ALL_WAREHOUSES"
    },
    FIND_WAREHOUSE {
        override val typeName = "FIND_WAREHOUSE"
    },
    CREATE_WAREHOUSE {
        override val typeName = "CREATE_WAREHOUSE"
    },
    UPDATE_WAREHOUSE {
        override val typeName = "UPDATE_WAREHOUSE"
    }
}