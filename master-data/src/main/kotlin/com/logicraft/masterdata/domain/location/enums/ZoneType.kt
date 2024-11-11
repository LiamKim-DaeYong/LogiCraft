package com.logicraft.masterdata.domain.location.enums

enum class ZoneType {
    INBOUND, // 입고존
    OUTBOUND, // 출고존
    STORAGE, // 보관존
    PICKING, // 피킹존
    QUALITY_INSPECTION, // 검사존
    RETURNS, // 반품존
    CROSS_DOCKING, // 혼류존
    STAGING, // 출하 대기존
    PACKING, // 포장존
}
