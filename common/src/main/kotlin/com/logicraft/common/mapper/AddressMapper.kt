package com.logicraft.common.mapper

import com.logicraft.common.entity.AddressJpaEntity
import com.logicraft.common.model.Address

fun Address.toJpaEntity(): AddressJpaEntity {
    return AddressJpaEntity(
        city = city,
        street = street,
        postalCode = postalCode,
        country = country,
        detailAddress = detailAddress,
        provinceOrState = provinceOrState
    )
}

fun AddressJpaEntity.toDomainEntity(): Address {
    return Address(
        city = city,
        street = street,
        postalCode = postalCode,
        country = country,
        detailAddress = detailAddress,
        provinceOrState = provinceOrState
    )
}
