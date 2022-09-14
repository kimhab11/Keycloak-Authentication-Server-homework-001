package com.example.keycloak.homework.model.request

import com.example.keycloak.homework.model.entity.OperatingSystem

data class OperatingSystemRequest(
    val name: String,
    val version: String
){
    fun toEntity() = OperatingSystem(
        name = name,
        version = version
    )
}
