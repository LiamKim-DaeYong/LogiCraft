package com.logicraft.common.event

import com.logicraft.common.exception.InfrastructureException
import kotlinx.coroutines.CompletableDeferred
import org.slf4j.LoggerFactory
import java.util.concurrent.*

object EventResponseHandler {

    private val callbacks = ConcurrentHashMap<String, CompletableDeferred<*>>()
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private val logger = LoggerFactory.getLogger(EventResponseHandler::class.java)


    init {
        executor.scheduleAtFixedRate(::removeExpiredCallbacks, 1, 1, TimeUnit.MINUTES)
        Runtime.getRuntime().addShutdownHook(Thread { executor.shutdown() })
    }

    /**
     * 이벤트 콜백을 등록합니다.
     * @param event 등록할 이벤트 객체
     * @param deferred 콜백을 처리할 CompletableDeferred 객체
     * @param timeoutMillis 콜백 만료 시간 (기본 60초)
     */
    fun <T> registerCallback(
        event: Event,
        deferred: CompletableDeferred<T>,
        timeoutMillis: Long = 60000,
    ) {
        val correlationId = event.getCorrelationId()

        registerOrThrow(correlationId, deferred, event)
        scheduleTimeout(correlationId, timeoutMillis)
    }

    /**
     * 이벤트 콜백을 완료합니다.
     * @param event 완료할 이벤트 객체
     * @param result 콜백에 전달할 결과 값
     */
    @Suppress("UNCHECKED_CAST")
    fun completeEvent(event: Event, result: Any) {
        val correlationId = event.getCorrelationId()

        (callbacks.remove(correlationId) as? CompletableDeferred<Any?>)?.complete(result)
            ?: logger.warn("No callback found for correlationId: $correlationId")
    }

    /**
     * 만료된 콜백을 제거합니다.
     */
    private fun removeExpiredCallbacks() {
        callbacks.entries.removeIf { entry ->
            val callback = entry.value

            if (!callback.isActive) {
                callback.completeExceptionally(InfrastructureException.CallbackTimeoutException("Callback expired"))
                true
            } else {
                false
            }
        }
    }

    /**
     * 콜백을 등록하고 중복된 경우 예외를 던집니다.
     */
    private fun <T> registerOrThrow(
        correlationId: String,
        deferred: CompletableDeferred<T>,
        event: Event,
    ) {
        callbacks.putIfAbsent(correlationId, deferred)?.let {
            throw InfrastructureException.EventPublishingException("Callback with correlationId $correlationId is already registered, Event: $event")
        }
    }

    /**
     * 타임아웃 스케줄링
     */
    private fun scheduleTimeout(correlationId: String, timeoutMillis: Long) {
        executor.schedule({
            callbacks.remove(correlationId)?.completeExceptionally(
                InfrastructureException.CallbackTimeoutException("Callback timed out for correlationId: $correlationId")
            )
        }, timeoutMillis, TimeUnit.MILLISECONDS)
    }
}
