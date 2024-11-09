description = "LogiCraft Common Module"

plugins {
    id("nu.studer.jooq")
}

dependencies {
    jooqGenerator("org.postgresql:postgresql")
}

jooq {
    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(true)

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
                        directory = layout.buildDirectory.dir("generated/jooq").get().asFile.path
                        encoding = "UTF-8"
                    }
                }
            }
        }
    }
}
