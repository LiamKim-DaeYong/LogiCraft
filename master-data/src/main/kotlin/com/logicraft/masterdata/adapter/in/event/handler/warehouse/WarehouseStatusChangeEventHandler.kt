package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.masterdata.application.port.`in`.warehouse.WarehouseStatusChangeUseCase

class WarehouseStatusChangeEventHandler(
    private val warehouseStatusChangeUseCase: WarehouseStatusChangeUseCase,
)
