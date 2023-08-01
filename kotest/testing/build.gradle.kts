plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    kotlin("jvm")
}

group = "com.yoon"
version = "testing"

repositories {
    mavenCentral()
}

val kotestVersion: String by rootProject
val mockkVersion: String by rootProject
val kotestExtensionsSpringVersion: String by rootProject
val mockitoVersion: String by rootProject
val kotlinCoroutinesVersion: String by rootProject

dependencies {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-devtools")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestExtensionsSpringVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoVersion")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}