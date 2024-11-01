package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventListener
import com.logicraft.masterdata.application.port.`in`.warehouse.UpdateWarehouseUseCase

@EventListener
class UpdateWarehouseEventHandler(
    private val updateWarehouseUseCase: UpdateWarehouseUseCase,
) {
    fun handleUpdateWarehouseEvent() {
        // TODO: 이벤트를 처리하는 로직을 추가하세요.
    }
}