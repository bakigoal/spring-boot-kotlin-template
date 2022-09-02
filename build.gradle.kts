import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.7.10"
    id("org.openapi.generator") version "5.3.0"
}

group = "com.bakigoal"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.20")
    runtimeOnly("com.h2database:h2")

    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")

    implementation("org.mapstruct:mapstruct:1.5.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.2.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val oasGenOutputDir = project.layout.buildDirectory.dir("generated-oas")

tasks.register("generateServer", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
    input = project.file("src/main/resources/api/api-definition.yaml").path
    outputDir.set(oasGenOutputDir.get().toString())
    modelPackage.set("com.bakigoal.model")
    apiPackage.set("com.bakigoal.api")
    packageName.set("com.bakigoal")
    generatorName.set("kotlin-spring")
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8",
            "interfaceOnly" to "true",
            "useTags" to "true"
        )
    )
}

sourceSets {
    val main by getting
    main.java.srcDir("${oasGenOutputDir.get()}/src/main/kotlin")
    val test by getting
    test.java.srcDir("${oasGenOutputDir.get()}/src/main/kotlin")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
    dependsOn("generateServer")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
