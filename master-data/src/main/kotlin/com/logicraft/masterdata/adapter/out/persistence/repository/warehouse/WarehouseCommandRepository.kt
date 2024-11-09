package com.logicraft.masterdata.adapter.out.persistence.repository.warehouse

import com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseCommandRepository : JpaRepository<WarehouseJpaEntity, String>