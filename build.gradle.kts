plugins {
    application
    kotlin("jvm") version "1.9.23"
}

group = "org.theboys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.21")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    // lol tests
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

application {
    mainClass = "WeezingKt"
}

tasks.test {
    useJUnitPlatform()
}

val localDev: String? by project
val authToken: String? by project
tasks.withType<JavaExec> {
    systemProperty("DEBUG_ALL", localDev ?: "false")
    systemProperty("authToken", authToken ?: "")
}

kotlin {
    jvmToolchain(20)
}