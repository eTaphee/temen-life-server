package life.temen.build.convention.lib

import life.temen.build.convention.verion.Plugins.KOTLIN_SPRING
import life.temen.build.convention.verion.Plugins.SPRING_BOOT
import life.temen.build.convention.verion.Plugins.SPRING_DEPENDENCY_MANAGEMENT
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.exclude

class SpringConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("life.temen.build.convention.kotlin")
            plugin(SPRING_BOOT)
            plugin(SPRING_DEPENDENCY_MANAGEMENT)
            plugin(KOTLIN_SPRING)
        }

        target.dependencies.apply {
            add("implementation", "org.springframework.boot:spring-boot-starter")
            add("implementation", "org.springframework.boot:spring-boot-starter-log4j2")
            add("implementation", "org.springframework.boot:spring-boot-configuration-processor")
        }

        target.configurations.apply {
            all {
                exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
            }
        }
    }
}
