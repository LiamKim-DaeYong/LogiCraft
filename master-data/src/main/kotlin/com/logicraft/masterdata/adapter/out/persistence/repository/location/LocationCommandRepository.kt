package com.logicraft.masterdata.adapter.out.persistence.repository.location

import com.logicraft.masterdata.adapter.out.persistence.entity.location.LocationJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationCommandRepository : JpaRepository<LocationJpaEntity, String>
