package com.logicraft.common.event

sealed class EventCategory {
    data object DataModification : EventCategory()
    data object DataRetrieval : EventCategory()
    data object Notification : EventCategory()
    data object SystemEvent : EventCategory()
}

interface EventAction {
    val actionName: String
}

sealed class BasicEventAction(override val actionName: String) : EventAction {
    data object Query : BasicEventAction("QUERY")

    sealed class Command(actionName: String) : BasicEventAction(actionName) {
        data object Create : Command("CREATE")
        data object Update : Command("UPDATE")
        data object Delete : Command("DELETE")
    }
}