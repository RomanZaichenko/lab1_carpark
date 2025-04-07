plugins {
    id("java")
}

group = "kpi.lab1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.7.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
}

tasks.test {
    useJUnitPlatform()
}