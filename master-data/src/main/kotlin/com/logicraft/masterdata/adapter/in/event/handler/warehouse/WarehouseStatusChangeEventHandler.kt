package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventListener
import com.logicraft.masterdata.application.port.`in`.warehouse.WarehouseStatusChangeUseCase

@EventListener
class WarehouseStatusChangeEventHandler(
    private val warehouseStatusChangeUseCase: WarehouseStatusChangeUseCase
) {
}