package com.example.keycloak.homework.repository

import com.example.keycloak.homework.model.entity.OperatingSystem
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface OperatingSystemRepository : ReactiveCrudRepository<OperatingSystem,Long> {
}