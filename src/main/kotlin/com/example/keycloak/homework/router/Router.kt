package com.example.keycloak.homework.router

import com.example.keycloak.homework.handler.CloudInstanceHandler
import com.example.keycloak.homework.handler.OSHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(val cloudInstanceHandler: CloudInstanceHandler, val osHandler: OSHandler) {
    @Bean
    fun osRouter(): RouterFunction<ServerResponse> =
        router {
            "/api/v1".nest {
                POST("/os", osHandler::createOperatingSystem)
                GET("/os", osHandler::findAllOS)
                POST("/instance", cloudInstanceHandler::createCloudInstance)
                GET("/instance", cloudInstanceHandler::findAllCloudInstances)
                GET("/instance/users/{id}", cloudInstanceHandler::getAllCloudUsers)
            }
        }
}