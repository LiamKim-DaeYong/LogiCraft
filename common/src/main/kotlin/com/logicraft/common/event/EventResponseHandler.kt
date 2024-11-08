package com.logicraft.common.event

import kotlinx.coroutines.CompletableDeferred
import java.util.concurrent.*

object EventResponseHandler {
    private val callbacks = ConcurrentHashMap<String, CompletableDeferred<*>>()
    private val executor = Executors.newSingleThreadScheduledExecutor()

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
    fun <T> registerCallback(event: Event, deferred: CompletableDeferred<T>, timeoutMillis: Long = 60000) {
        val correlationId = event.metadata.correlationId
            ?: throw IllegalArgumentException("Event must have a correlationId")

        callbacks.putIfAbsent(correlationId, deferred)?.let {
            throw IllegalStateException("Callback with correlationId $correlationId is already registered")
        }

        executor.schedule({
            callbacks.remove(correlationId)?.completeExceptionally(TimeoutException("Callback timed out"))
        }, timeoutMillis, TimeUnit.MILLISECONDS)
    }

    /**
     * 이벤트 콜백을 완료합니다.
     * @param event 완료할 이벤트 객체
     * @param result 콜백에 전달할 결과 값
     */
    @Suppress("UNCHECKED_CAST")
    fun completeEvent(event: Event, result: Any) {
        val correlationId = event.metadata.correlationId
            ?: throw IllegalArgumentException("Event must have a correlationId")

        (callbacks.remove(correlationId) as? CompletableDeferred<Any?>)?.complete(result)
            ?: logWarning("No callback found for correlationId: $correlationId")
    }

    /**
     * 만료된 콜백을 제거합니다.
     */
    private fun removeExpiredCallbacks() {
        callbacks.entries.removeIf { entry ->
            val callback = entry.value
            if (!callback.isActive) {
                callback.completeExceptionally(TimeoutException("Callback expired"))
                true
            } else {
                false
            }
        }
    }

    /**
     * 경고를 로그로 출력합니다.
     */
    private fun logWarning(message: String) {
        // TODO("로깅 라이브러리로 치환")
        println("Warning: $message")
    }
}