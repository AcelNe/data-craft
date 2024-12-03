plugins {
    id("java")
}

group = "work"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Lombok 의존성 추가
    compileOnly("org.projectlombok:lombok:1.18.24")  // Lombok을 컴파일 타임에만 사용
    annotationProcessor("org.projectlombok:lombok:1.18.24")  // Lombok 어노테이션 처리기
}

tasks.test {
    useJUnitPlatform()
}