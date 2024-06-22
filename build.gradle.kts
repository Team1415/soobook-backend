plugins {
  java
  id("org.springframework.boot") version "3.1.1"
  id("io.spring.dependency-management") version "1.1.0"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  // id("org.flywaydb.flyway") version "9.20.0"
  id("com.diffplug.spotless") version "6.19.0"
  id("org.springdoc.openapi-gradle-plugin") version "1.6.0"
}

group = "com.team1415"
version = "0.0.1-SNAPSHOT"

val querydslVersion = "5.0.0"
val jakartaApiVersion = "3.1.0"

java {
  sourceCompatibility = JavaVersion.VERSION_17
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

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.apache.kafka:kafka-streams")
  // implementation("org.flywaydb:flyway-core")
  // implementation("org.flywaydb:flyway-mysql")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
  implementation("org.apache.commons:commons-csv:1.10.0")
  implementation("org.apache.commons:commons-collections4:4.4")
  implementation("commons-io:commons-io:2.13.0")
  implementation("com.opencsv:opencsv:5.5")
  implementation("com.github.ozlerhakan:poiji:4.1.1")

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
  implementation("org.mapstruct:mapstruct:1.5.5.Final")
  annotationProcessor("org.projectlombok:lombok")
  annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.testcontainers:testcontainers")
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
  testImplementation("org.testcontainers:kafka")
}

tasks.withType<JavaCompile> {
  options.annotationProcessorPath = configurations.annotationProcessor.get()
  options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

tasks.withType<Test> {
  useJUnitPlatform()
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
  options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

//flyway {
//  url = "jdbc:mysql://localhost:3306/soobook-database?useSSL=false&allowPublicKeyRetrieval=true"
//  locations = arrayOf("filesystem:./src/main/resources/flyway/ddl", "filesystem:./src/main/resources/flyway/dml/local")
//  user = "root"
//  password = "verysecret"
//  schemas = arrayOf("soobook-database")
//  sqlMigrationSuffixes = arrayOf(".sql")
//  outOfOrder = true
//  baselineOnMigrate = true
//}

tasks.named("clean") {
  doLast {
    file(querydslDir).deleteRecursively()
  }
}

tasks.named("spotlessApply") {
  dependsOn("compileJava")
}

spotless {
  java {
    target("src/**/*.java", "build/generated-sources/**/*.java")
    importOrder("java", "jakarta", "javax", "org", "com", "common", "")
    removeUnusedImports()

    indentWithSpaces(4)
    trimTrailingWhitespace()
    endWithNewline()

    googleJavaFormat().aosp()
  }

  format("misc") {
    target("**/*.yml", "**/*.gradle", "**/*.md", "**/.gitignore")
    indentWithSpaces(2)
    trimTrailingWhitespace()
    endWithNewline()
  }

  format("misc_gradle_kts") {
    target("**/*.gradle.kts")
    indentWithSpaces(2)
    trimTrailingWhitespace()
    endWithNewline()
  }
}
