import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    application
    kotlin("jvm") version "1.2.71"
}

application {
    mainClassName = "com.joerosenbecker.kotlinwebsockets.seed.SeedRunnerKt"
}

group = "com.joerosenbecker"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.exposed:exposed:0.16.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("mysql:mysql-connector-java:8.0.17")
    testCompile("junit", "junit", "4.12")
    compile(project(":kotlin-websockets-data"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}