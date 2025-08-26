plugins {
  java
  id("org.springframework.boot") version "3.5.4"
  id("io.spring.dependency-management") version "1.1.7"
  id("org.asciidoctor.jvm.convert") version "4.0.4"
  id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
}

group = "com.team1415"
version = "0.0.1-SNAPSHOT"

val querydslVersion = "5.0.0"
val jakartaApiVersion = "3.1.0"
extra["lombok.version"] = "1.18.38"


java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(24))
  }
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }
val jwtVersion by extra { "0.13.0" }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
  implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.apache.kafka:kafka-streams")
  implementation ("io.jsonwebtoken:jjwt-api:$jwtVersion")
  runtimeOnly("io.jsonwebtoken:jjwt-impl:$jwtVersion")
  runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jwtVersion")
  implementation("org.mapstruct:mapstruct:1.6.3")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.8")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.8")
  implementation("org.apache.commons:commons-csv:1.14.1")
  implementation("org.apache.commons:commons-collections4:4.5.0")
  implementation("commons-io:commons-io:2.20.0")
  implementation("com.opencsv:opencsv:5.12.0")
  implementation("com.github.ozlerhakan:poiji:4.9.0")

  // QueryDSL Implementation
  implementation("com.querydsl:querydsl-jpa:${querydslVersion}:jakarta")
  implementation("com.querydsl:querydsl-core:${querydslVersion}")
  implementation("com.querydsl:querydsl-collections")
  annotationProcessor("com.querydsl:querydsl-apt:${querydslVersion}:jakarta")
  annotationProcessor("jakarta.annotation:jakarta.annotation-api")
  annotationProcessor("jakarta.persistence:jakarta.persistence-api")
  testImplementation("jakarta.persistence:jakarta.persistence-api")
  testImplementation("com.querydsl:querydsl-jpa:${querydslVersion}")

  compileOnly("org.projectlombok:lombok")
  implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
  implementation("org.mapstruct:mapstruct:1.6.3")
  annotationProcessor("org.projectlombok:lombok")
  annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.projectlombok" && requested.name == "lombok") {
            useVersion("1.18.38")
        }
    }
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations.annotationProcessor.get()
    options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperties(System.getProperties().toMap() as Map<String, Any>)
}

tasks.test {
  outputs.dir(snippetsDir)
}

tasks.asciidoctor {
  inputs.dir(snippetsDir)
  dependsOn(tasks.test)
}

val querydslDir = "src/main/generated"

sourceSets {
  getByName("main").java.srcDirs(querydslDir)
}

tasks.withType<JavaCompile> {
  options.generatedSourceOutputDirectory.set(file(querydslDir))
}

tasks.named("clean") {
  doLast {
    file(querydslDir).deleteRecursively()
  }
}
