plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("nu.studer.jooq")
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
        jooqGenerator("org.postgresql:postgresql")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    springBoot {
        mainClass.set("com.logicraft.core.CoreApplication")
    }

    jooq {
        configurations {
            create("main") {
                generateSchemaSourceOnCompilation.set(false)

                jooqConfiguration.apply {
                    jdbc.apply {
                        driver = "org.postgresql.Driver"
                        url = "jdbc:postgresql://localhost:5432/logicraft_db"
                        user = "logicraft_user"
                        password = "logicraft_password"
                    }
                    generator.apply {
                        name = "org.jooq.codegen.KotlinGenerator"
                        database.apply {
                            name = "org.jooq.meta.postgres.PostgresDatabase"
                            inputSchema = "public"
                        }
                        generate.apply {
                            isDaos = false
                            isRecords = true
                            isFluentSetters = true
                            isJavaTimeTypes = true
                            isDeprecated = false

                            withKotlinNotNullPojoAttributes(true)
                            withKotlinNotNullRecordAttributes(true)
                        }
                        target.apply {
                            packageName = "com.logicraft.generated.jooq"
                            directory = "src/generated"
                            encoding = "UTF-8"
                        }
                    }
                }
            }
        }
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
