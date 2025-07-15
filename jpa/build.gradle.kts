// jpa/build.gradle.kts

plugins {
    `java-library`
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    // ❌ 'com.ewerk.gradle.plugins.querydsl' 플러그인을 완전히 삭제합니다.
}

// ✅ QueryDSL 관련 설정을 직접 추가합니다.
// 생성된 Q-Type 클래스가 저장될 디렉토리입니다.
val querydslDir = "build/generated/querydsl"

sourceSets {
    main {
        java {
            srcDir(querydslDir) // 생성된 소스 경로를 main 소스셋에 추가
        }
    }
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-jpa:5.1.0:jakarta")

    // QueryDSL 코드를 생성하는 데 필요한 어노테이션 프로세서입니다.
    annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")

    val lombokVersion = "1.18.32"
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// ✅ 컴파일 시 QueryDSL 관련 클래스들을 생성하도록 작업을 설정합니다.
tasks.withType<JavaCompile> {
    options.generatedSourceOutputDirectory.set(file(querydslDir))
}

// 라이브러리 모듈이므로 bootJar는 비활성화합니다.
tasks.bootJar { enabled = false }
tasks.jar { enabled = true }