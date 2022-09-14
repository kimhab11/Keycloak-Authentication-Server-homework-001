package com.example.keycloak.homework.service.cloudinstance

import com.example.keycloak.homework.model.dto.OperatingSystemDto
import com.example.keycloak.homework.model.entity.OperatingSystem
import com.example.keycloak.homework.model.request.OperatingSystemRequest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface OperatingSystemService {

    fun save(os: OperatingSystemRequest): Mono<OperatingSystemDto>

    fun findAll(): Flux<OperatingSystemDto>
    fun findById(operatingSystemId: Long): Mono<OperatingSystem>
}