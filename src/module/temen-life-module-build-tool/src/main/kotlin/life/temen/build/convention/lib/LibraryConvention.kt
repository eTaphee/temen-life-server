package life.temen.build.convention.lib

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LibraryConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply {
            apply("life.temen.build.convention.kotlin")
            apply("life.temen.build.convention.spring")
            apply("life.temen.build.convention.test")
        }

        target.dependencies {
        }

        val bootJarTask = target.tasks.find { it.name == "bootJar" }
        bootJarTask?.let {
            it.enabled = false
        }
    }
}
