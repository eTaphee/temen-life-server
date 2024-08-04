package life.temen.build.convention.verion

object Plugins {
    const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
    const val KOTLIN_SPRING = "org.jetbrains.kotlin.plugin.spring"
    const val SPRING_BOOT = "org.springframework.boot"
    const val SPRING_DEPENDENCY_MANAGEMENT = "io.spring.dependency-management"
    const val KOTLIN_DSL = "org.gradle.kotlin.kotlin-dsl"

    object Version {
        const val KOTLIN = "1.9.22"
        const val SPRING_BOOT = "3.3.2"
        const val SPRING_DEPENDENCY_MANAGEMENT = "1.1.6"
    }
}
