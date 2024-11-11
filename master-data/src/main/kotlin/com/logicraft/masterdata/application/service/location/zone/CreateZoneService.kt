package com.logicraft.masterdata.application.service.location.zone

import com.logicraft.common.enums.ActiveStatus
import com.logicraft.common.exception.DomainException
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneCommand
import com.logicraft.masterdata.application.port.`in`.location.zone.CreateZoneUseCase
import com.logicraft.masterdata.application.port.out.location.zone.CreateZonePort
import com.logicraft.masterdata.application.port.out.warehouse.FindWarehousePort
import com.logicraft.masterdata.domain.location.LocationId
import com.logicraft.masterdata.domain.location.LocationName
import com.logicraft.masterdata.domain.location.Zone
import com.logicraft.masterdata.domain.location.ZoneCode
import com.logicraft.masterdata.domain.location.policy.FifoPolicy
import com.logicraft.masterdata.domain.warehouse.Warehouse
import com.logicraft.masterdata.domain.warehouse.WarehouseId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class CreateZoneService(
    private val createZonePort: CreateZonePort,
    private val findWarehousePort: FindWarehousePort,
) : CreateZoneUseCase {
    override fun createZone(command: CreateZoneCommand): Zone {
        val warehouseId = WarehouseId(command.warehouseId)

        // TODO(ExistWarehouseUseCase 추가 후 변경)
        findWarehousePort.findWarehouseById(warehouseId) ?: throw DomainException.NotFoundException(Warehouse::class, warehouseId.value)

        val zone =
            Zone(
                id = LocationId(UUID.randomUUID().toString()),
                warehouseId = warehouseId,
                name = LocationName(command.name),
                code = ZoneCode(command.code),
                type = command.type,
                activeStatus = ActiveStatus.ACTIVE,
                storagePolicy = FifoPolicy(),
            )

        return createZonePort.createZone(zone)
    }
}
