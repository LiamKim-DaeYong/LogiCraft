package com.core.mapper

import com.core.entity.AddressJpaEntity
import com.core.model.Address

object AddressMapper {
    fun toJpaEntity(address: Address): AddressJpaEntity {
        return AddressJpaEntity(
            city = address.city,
            street = address.street,
            postalCode = address.postalCode,
            country = address.country,
            detailAddress = address.detailAddress,
            provinceOrState = address.provinceOrState
        )
    }

    fun toDomainEntity(addressJpaEntity: AddressJpaEntity): Address {
        return Address(
            city = addressJpaEntity.city,
            street = addressJpaEntity.street,
            postalCode = addressJpaEntity.postalCode,
            country = addressJpaEntity.country,
            detailAddress = addressJpaEntity.detailAddress,
            provinceOrState = addressJpaEntity.provinceOrState
        )
    }
}