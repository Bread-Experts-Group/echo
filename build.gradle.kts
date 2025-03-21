plugins {
    application
    kotlin("jvm") version "2.1.10"
}

group = "bread_experts_group"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(9)
}

application {
    mainClass = "bread_experts_group.MainKt"
}