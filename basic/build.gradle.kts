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
    fun starter(name: String, isTestDependency: Boolean = false): ExternalModuleDependency {
        val group = "org.springframework.boot"
        val artifact = "spring-boot-starter-$name"
        val version = "2.0.3.RELEASE"
        return when (isTestDependency) {
            true -> testImplementation(group, artifact, version)
            false -> implementation(group, artifact, version)
        }
    }
    fun testStarter(name: String) { starter(name, isTestDependency = true) }

    starter("web")
    starter("thymeleaf")
    starter("security")
    testStarter("test")

    testImplementation("org.springframework.security", "spring-security-test", "5.0.6.RELEASE")
}

fun DependencyHandlerScope.junit() {
    testImplementation("junit", "junit", "4.12")
}
