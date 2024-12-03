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

    //json
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")

    //jsch
    implementation("com.jcraft:jsch:0.1.55")

    //fileutils
    // https://mvnrepository.com/artifact/commons-io/commons-io
    implementation("commons-io:commons-io:2.18.0")

}

tasks.test {
    useJUnitPlatform()
}