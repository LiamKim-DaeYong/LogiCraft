package com.logicraft.common.event

interface EventProcessor<T : Event> {

    fun handle(event: T)
}
