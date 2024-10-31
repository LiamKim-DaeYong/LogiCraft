rootProject.name = "LogiCraft"

include("common")
include("core")
//include("inventory")
//include("lot-management")
include("master-data")
//include("purchase-order")
//include("receiving")
//include("serial-number")
//include("shipping")

rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
}

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val jooqVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "nu.studer.jooq" -> useVersion(jooqVersion)
            }
        }
    }
}
