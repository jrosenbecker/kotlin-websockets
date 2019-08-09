import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
}

application {
    mainClassName = "com.joerosenbecker.kotlinwebsockets.data.MigrationRunnerKt"
}

group = "com.joerosenbecker"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


dependencies {
    implementation("org.jetbrains.exposed:exposed:0.16.1")
    implementation("io.github.microutils:kotlin-logging:1.7.4")
    runtimeOnly("mysql:mysql-connector-java:8.0.17")
}
