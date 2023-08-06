plugins {
  java
  id("org.springframework.boot") version "3.1.1"
  id("io.spring.dependency-management") version "1.1.0"
  id("org.graalvm.buildtools.native") version "0.9.23"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  id("org.flywaydb.flyway") version "9.20.0"
  id("com.diffplug.spotless") version "6.19.0"
  id("org.springdoc.openapi-gradle-plugin") version "1.6.0"
}

group = "com.team1415"
version = "0.0.1-SNAPSHOT"

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
val jwtVersion by extra { "0.11.5" }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
  implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.apache.kafka:kafka-streams")
  implementation("org.flywaydb:flyway-core")
  implementation("org.flywaydb:flyway-mysql")
  implementation ("io.jsonwebtoken:jjwt-api:$jwtVersion")
  runtimeOnly("io.jsonwebtoken:jjwt-impl:$jwtVersion")
  runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jwtVersion")
  implementation("org.mapstruct:mapstruct:1.5.5.Final")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
  compileOnly("org.projectlombok:lombok")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  runtimeOnly("com.mysql:mysql-connector-j")
  annotationProcessor("org.projectlombok:lombok")
  annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-testcontainers")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("org.testcontainers:kafka")
  testImplementation("org.testcontainers:mysql")
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

tasks.withType<JavaCompile> {
  options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

flyway {
  url = "jdbc:mysql://localhost:3306/soobook-database?useSSL=false&allowPublicKeyRetrieval=true"
  locations = arrayOf("filesystem:./src/main/resources/flyway/ddl", "filesystem:./src/main/resources/flyway/dml/local")
  user = "root"
  password = "verysecret"
  schemas = arrayOf("soobook-database")
  sqlMigrationSuffixes = arrayOf(".sql")
  outOfOrder = true
  baselineOnMigrate = true
}

spotless {
  java {
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
