package com.logicraft.common.annotations

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class EventHandlerAdapter(
    @get:AliasFor(annotation = Component::class)
    val value: String = ""
)