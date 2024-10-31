package com.logicraft.masterdata.adapter.out.persistence.repository.warehouse

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseJpaRepository : JpaRepository<com.logicraft.masterdata.adapter.out.persistence.entity.warehouse.WarehouseJpaEntity, String>