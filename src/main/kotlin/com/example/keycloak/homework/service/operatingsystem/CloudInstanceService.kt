package com.example.keycloak.homework.service.operatingsystem

import com.example.keycloak.homework.model.dto.CloudInstanceDto
import com.example.keycloak.homework.model.request.CloudInstanceRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CloudInstanceService {

    fun create(cloudInstanceRequest: CloudInstanceRequest): Mono<CloudInstanceDto>

    fun findAll(): Flux<CloudInstanceDto>
}