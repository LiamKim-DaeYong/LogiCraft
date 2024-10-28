package com.core.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AddressJpaEntity(
    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "street", nullable = false)
    val street: String,

    @Column(name = "postal_code", nullable = false)
    val postalCode: String,

    @Column(name = "country", nullable = false)
    val country: String,

    @Column(name = "detail_address")
    val detailAddress: String? = null,

    @Column(name = "province_or_state")
    val provinceOrState: String? = null
)