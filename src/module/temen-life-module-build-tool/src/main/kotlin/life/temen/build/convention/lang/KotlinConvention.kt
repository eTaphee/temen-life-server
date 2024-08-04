package life.temen.build.convention.lang

import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("org.jetbrains.kotlin.jvm")
            plugin("org.jetbrains.kotlin.kapt")
        }

        target.dependencies.apply {
            add("implementation", "org.jetbrains.kotlin:kotlin-reflect")
        }
    }
}
