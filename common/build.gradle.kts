// common/build.gradle.kts

plugins {
    `java-library` // ✅ 'kotlin("jvm")'을 완전히 삭제합니다.
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

val mapstructVersion = "1.5.5.Final"
val lombokVersion = "1.18.32"

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    api("org.mapstruct:mapstruct:$mapstructVersion")

    api("jakarta.validation:jakarta.validation-api:3.0.2")
    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.17")
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
}