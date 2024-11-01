package com.logicraft.masterdata.adapter.`in`.event.handler.warehouse

import com.logicraft.common.annotations.EventListener
import com.logicraft.masterdata.application.port.`in`.warehouse.WarehouseMaintenanceUseCase

@EventListener
class WarehouseMaintenanceEventHandler(
    private val warehouseMaintenanceUseCase: WarehouseMaintenanceUseCase
) {
}