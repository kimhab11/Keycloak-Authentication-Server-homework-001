package com.example.keycloak.homework.model.request

import com.example.keycloak.homework.model.entity.CloudInstance
import kotlin.random.Random

data class CloudInstanceRequest(
    val instanceName: String,
    val operatingSystemId: Long
){
    fun toEntity() = CloudInstance(
        instanceName = instanceName,
        operatingSystemId = operatingSystemId,
        publicIpAddress = "${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}.${Random.nextInt(0,256)}"
    )
}