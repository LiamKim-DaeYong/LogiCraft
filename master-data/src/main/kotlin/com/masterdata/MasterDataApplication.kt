package com.masterdata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterDataApplication

fun main(args: Array<String>) {
    runApplication<MasterDataApplication>(*args)
}
