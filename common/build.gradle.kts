// common/build.gradle.kts

plugins {
    `java-library`
    id("java-test-fixtures")
}

val mapstructVersion = "1.5.5.Final"
val lombokVersion = "1.18.32"

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    api("org.mapstruct:mapstruct:$mapstructVersion")

    api("jakarta.validation:jakarta.validation-api:3.0.2")

    testFixturesImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.17")
}