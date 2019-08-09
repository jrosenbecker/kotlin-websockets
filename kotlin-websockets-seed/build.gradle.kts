import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    application
}

application {
    mainClassName = "com.joerosenbecker.kotlinwebsockets.seed.SeedRunnerKt"
}

group = "com.joerosenbecker"
version = "0.0.1-SNAPSHOT"


dependencies {
    implementation("org.jetbrains.exposed:exposed:0.16.1")
    runtimeOnly("mysql:mysql-connector-java:8.0.17")
    compile(project(":kotlin-websockets-data"))
}