package com.logicraft.core.controller

import com.logicraft.common.response.ApiResponse
import com.logicraft.core.orchestration.masterdata.ZoneEventOrchestrator
import com.logicraft.masterdata.adapter.`in`.dto.location.mapper.toCreateZoneCommand
import com.logicraft.masterdata.adapter.`in`.dto.location.request.CreateZoneRequest
import com.logicraft.masterdata.adapter.`in`.dto.location.response.CreateZoneResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/locations/zones")
class ZoneController(
    private val zoneEventOrchestrator: ZoneEventOrchestrator
) {

    @PostMapping
    suspend fun createLocation(
        @RequestBody createZoneRequest: CreateZoneRequest,
    ): ApiResponse<CreateZoneResponse> {
        return zoneEventOrchestrator.createZone(
            createZoneRequest.toCreateZoneCommand(),
        ).let {
            ApiResponse.created(
                message = "Zone created successfully",
                data = it
            )
        }
    }
}
