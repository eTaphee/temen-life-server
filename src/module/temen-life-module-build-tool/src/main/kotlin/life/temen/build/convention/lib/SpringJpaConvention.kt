package life.temen.build.convention.lib

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.noarg.gradle.NoArgExtension

class SpringJpaConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply {
                plugin(KotlinPluginWrapper::class.java)
                plugin("org.jetbrains.kotlin.plugin.allopen")
                plugin("org.jetbrains.kotlin.plugin.noarg")
            }

            dependencies {
                add("implementation", "org.springframework.boot:spring-boot-starter-data-jpa")
                add("implementation", "com.querydsl:querydsl-jpa:5.0.0:jakarta")
                add("kapt", "com.querydsl:querydsl-apt:5.0.0:jakarta")
                add("kapt", "jakarta.persistence:jakarta.persistence-api")
                add("kapt", "jakarta.annotation:jakarta.annotation-api")
            }

            configure<AllOpenExtension> {
                annotation("jakarta.persistence.Entity")
                annotation("jakarta.persistence.MappedSuperclass")
                annotation("jakarta.persistence.Embeddable")
            }

            configure<NoArgExtension> {
                annotation("jakarta.persistence.Entity")
                annotation("jakarta.persistence.MappedSuperclass")
                annotation("jakarta.persistence.Embeddable")
            }
        }
    }
}
