plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("i am using ")
}

group = "com.herbert"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("io.mongock:mongock-bom:5.0.34")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.mapstruct:mapstruct:1.5.0.Beta1")
    implementation("io.mongock:mongodb-springdata-v3-driver")
    implementation("io.mongock:mongock-springboot")
    implementation("com.byteowls:jopencage:1.4.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}

configure<CheckstyleExtension> {
    toolVersion = "10.12.5" // Specify your desired Checkstyle version
    configFile = rootProject.file("config/checkstyle.xml")
}
