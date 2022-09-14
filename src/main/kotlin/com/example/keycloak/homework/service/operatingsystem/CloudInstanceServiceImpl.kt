package com.example.keycloak.homework.service.operatingsystem

import com.example.keycloak.homework.model.dto.CloudInstanceDto
import com.example.keycloak.homework.model.request.CloudInstanceRequest
import com.example.keycloak.homework.repository.CloudInstanceRepository
import com.example.keycloak.homework.repository.OperatingSystemRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CloudInstanceServiceImpl(
    val cloudInstanceRepository: CloudInstanceRepository,
    val operatingSystemRepository: OperatingSystemRepository
) : CloudInstanceService {
    override fun create(cloudInstanceRequest: CloudInstanceRequest): Mono<CloudInstanceDto> {
        return cloudInstanceRepository
            .save(cloudInstanceRequest.toEntity())
            .map { res -> res.toDto() }
    }

    override fun findAll(): Flux<CloudInstanceDto> {
        val cloudInstanceMono = cloudInstanceRepository
            .findAll()

        val osMono = cloudInstanceMono
            .flatMap {
                operatingSystemRepository.findById(it.operatingSystemId)
            }
        return cloudInstanceMono.zipWith(osMono)
            .map {
                val cloud = it.t1
                val myos = it.t2

                val cloudResponse = cloud.toDto()
                cloudResponse.operatingSystem = myos.toDto()

                cloudResponse
            }
    }
}