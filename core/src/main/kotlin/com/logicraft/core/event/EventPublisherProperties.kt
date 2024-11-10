package com.logicraft.core.event

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "event.publisher")
class EventPublisherProperties {
    var timeoutMillis: Long = 5000
    var maxRetries: Int = 3
    var retryDelayMillis: Long = 1000
}
