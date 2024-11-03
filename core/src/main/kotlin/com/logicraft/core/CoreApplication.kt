package com.logicraft.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.logicraft"])
@EntityScan(basePackages = ["com.logicraft"])
@EnableJpaRepositories(basePackages = ["com.logicraft"])
class CoreApplication

fun main(args: Array<String>) {
    runApplication<CoreApplication>(*args)
}
