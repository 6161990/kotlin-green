plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    kotlin("kapt")

    id("org.jlleitschuh.gradle.ktlint")
}

group = "com.yoon.subscriptions"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")

    tasks.getByName<Test>("test") {
        useJUnitPlatform {
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    kapt {
        correctErrorTypes = true
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("org.mapstruct:mapstruct:1.5.3.Final")
        implementation("org.valid4j:valid4j:0.5.0")
        kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
        kaptTest("org.mapstruct:mapstruct-processor:1.5.3.Final")

        testImplementation ("junit:junit:4.13")
        testImplementation("org.assertj:assertj-core:3.24.2")
        testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
        testImplementation("io.kotest:kotest-assertions-core:5.5.5")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        testImplementation("io.mockk:mockk:1.13.4")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("org.mapstruct:mapstruct:1.5.3.Final")
        implementation("org.valid4j:valid4j:0.5.0")
        kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
        kaptTest("org.mapstruct:mapstruct-processor:1.5.3.Final")

        testImplementation ("junit:junit:4.13")
        testImplementation("org.assertj:assertj-core:3.24.2")
        testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
        testImplementation("io.kotest:kotest-assertions-core:5.5.5")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        testImplementation("io.mockk:mockk:1.13.4")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
    }

    repositories {
        mavenCentral()
    }
}

tasks {
    // FIXME
    // defaultTasks.add(":order-api:bootTestRun")
}
