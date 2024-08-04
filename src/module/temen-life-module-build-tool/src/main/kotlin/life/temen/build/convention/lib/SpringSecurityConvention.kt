package life.temen.build.convention.lib

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SpringSecurityConvention : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply {
            apply("life.temen.build.convention.spring")
        }

        target.dependencies {
            add("api", "org.springframework.boot:spring-boot-starter-security")
            add("testApi", "org.springframework.security:spring-security-test")
        }
    }
}
