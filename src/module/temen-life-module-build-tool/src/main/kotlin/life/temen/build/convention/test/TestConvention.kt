package life.temen.build.convention.test

import life.temen.build.convention.verion.Plugins.KOTLIN_JVM
import life.temen.build.convention.verion.Plugins.SPRING_BOOT
import life.temen.build.convention.verion.Plugins.SPRING_DEPENDENCY_MANAGEMENT
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.withType

class TestConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin(KOTLIN_JVM)
            plugin(SPRING_BOOT)
            plugin(SPRING_DEPENDENCY_MANAGEMENT)
        }

        target.dependencies.apply {
            add("testImplementation", "org.springframework.boot:spring-boot-starter-test")
            add("testImplementation", "io.mockk:mockk:1.13.10")
            add("testImplementation", "io.kotest:kotest-runner-junit5:5.9.0")
            add("testImplementation", "io.kotest:kotest-runner-junit5-jvm:5.8.1")
            add("testImplementation", "io.kotest:kotest-assertions-core:5.8.1")
            add("testImplementation", "io.kotest:kotest-framework-datatest:5.8.1")
        }

        target.tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}
