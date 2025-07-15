// api/build.gradle.kts

plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":common"))
    implementation(project(":jpa"))

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.register("prepareKotlinBuildScriptModel"){}
// 이 모듈만 실행 가능한 jar로 만듭니다.
tasks.bootJar { enabled = true }
tasks.jar { enabled = false }