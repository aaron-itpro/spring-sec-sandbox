group = "com.us.itp.sandbox.springsec"
version = "1.0-SNAPSHOT"

plugins {
    java
    id("org.springframework.boot") version "2.0.3.RELEASE"
}

repositories {
    jcenter()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    spring()
    junit()
}

fun DependencyHandlerScope.spring() {
    val version = "2.0.3.RELEASE"
    "org.springframework.boot:spring-boot-starter".let {
        implementation("$it-web:$version")
        implementation("$it-thymeleaf:$version")
        testImplementation("$it-test:$version")
    }
}

fun DependencyHandlerScope.junit() {
    testImplementation("junit", "junit", "4.12")
}
