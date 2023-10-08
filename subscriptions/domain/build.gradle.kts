plugins {
    `java-library`
    id("java-test-fixtures")
}

dependencies {
    implementation(project(mapOf("path" to ":values")))
}

