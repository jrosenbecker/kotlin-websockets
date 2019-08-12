import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.joerosenbecker"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

springBoot {
    mainClassName = "com.joerosenbecker.kotlinwebsockets.KotlinwebsocketsApplication"
}

plugins {
    id("org.springframework.boot") version "2.1.7.RELEASE"
    kotlin("jvm")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(project(":kotlin-websockets-service"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}