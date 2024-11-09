plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("nu.studer.jooq")
    id("org.jlleitschuh.gradle.ktlint")
}

val version: String by project
val projectGroup: String by project
allprojects {
    group = projectGroup
    version = version

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "nu.studer.jooq")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.postgresql:postgresql")
        implementation("org.springframework.boot:spring-boot-starter-jooq")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    springBoot {
        mainClass.set("com.logicraft.core.CoreApplication")
    }

    kotlin {
        sourceSets {
            val main by getting {
                kotlin.srcDirs(
                    "src/main/kotlin",
                    layout.buildDirectory.dir("generated/jooq").get().asFile.path,
                )
                resources.srcDir("src/main/resources")
            }

            val test by getting {
                kotlin.srcDir("src/test/kotlin")
                resources.srcDir("src/test/resources")
            }
        }
    }

    ktlint {
        ignoreFailures = true
        filter {
            exclude { entry ->
                entry.file.toString().run { contains("generated") || contains("test") }
            }
        }
    }

    tasks.processResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName("jar") {
    enabled = true
}
