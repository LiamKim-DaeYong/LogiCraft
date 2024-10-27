package com.core.model

data class Address(
    val city: String,
    val street: String,
    val postalCode: String,
    val country: String,
    val detailAddress: String? = null,
    val provinceOrState: String? = null
)
