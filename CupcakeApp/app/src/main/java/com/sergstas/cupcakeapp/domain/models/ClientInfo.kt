package com.sergstas.cupcakeapp.domain.models

data class ClientInfo(
    val firstName: String,
    val lastName: String?,
    val contacts: String,
    val birthDate: String?
)