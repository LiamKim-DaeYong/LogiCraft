package com.logicraft.masterdata.adapter.out.persistence.repository.warehouse

import com.logicraft.generated.jooq.tables.records.WarehouseRecord
import com.logicraft.generated.jooq.tables.references.WAREHOUSE
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class WarehouseQueryRepository(private val dslContext: DSLContext) {
    fun findAll(): List<WarehouseRecord> {
        return dslContext
            .selectFrom(WAREHOUSE)
            .fetch()
    }

    fun findById(warehouseId: String): WarehouseRecord? {
        return dslContext
            .selectFrom(WAREHOUSE)
            .where(WAREHOUSE.WAREHOUSE_ID.eq(warehouseId))
            .fetchOne()
    }
}
