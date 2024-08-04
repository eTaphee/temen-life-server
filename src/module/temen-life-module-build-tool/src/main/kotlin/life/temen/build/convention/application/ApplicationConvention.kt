package life.temen.build.convention.application

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.withType
import org.springframework.boot.gradle.tasks.bundling.BootJar

class ApplicationConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("life.temen.build.convention.kotlin")
            plugins.apply("life.temen.build.convention.spring")
            plugins.apply("life.temen.build.convention.test")

            tasks.withType<Jar> {
                enabled = false
            }
            tasks.withType<BootJar> {
                enabled = true
            }
        }
    }
}
