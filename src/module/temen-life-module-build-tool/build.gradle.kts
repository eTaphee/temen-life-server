plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("application-convention") {
            id = "life.temen.build.convention.application"
            implementationClass = "life.temen.build.convention.application.ApplicationConvention"
        }

        create("kotlin-convention") {
            id = "life.temen.build.convention.kotlin"
            implementationClass = "life.temen.build.convention.lang.KotlinConvention"
        }

        create("library-convention") {
            id = "life.temen.build.convention.library"
            implementationClass = "life.temen.build.convention.lib.LibraryConvention"
        }

        create("spring-convention") {
            id = "life.temen.build.convention.spring"
            implementationClass = "life.temen.build.convention.lib.SpringConvention"
        }

        create("spring-jpa-convention") {
            id = "life.temen.build.convention.spring-jpa"
            implementationClass = "life.temen.build.convention.lib.SpringJpaConvention"
        }

        create("spring-security-convention") {
            id = "life.temen.build.convention.spring-security"
            implementationClass = "life.temen.build.convention.lib.SpringSecurityConvention"
        }

        create("spring-web-convention") {
            id = "life.temen.build.convention.spring-web"
            implementationClass = "life.temen.build.convention.lib.SpringWebConvention"
        }

        create("test-convention") {
            id = "life.temen.build.convention.test"
            implementationClass = "life.temen.build.convention.test.TestConvention"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    implementation("org.jetbrains.kotlin:kotlin-allopen:2.0.0")
    implementation("org.jetbrains.kotlin:kotlin-noarg:2.0.0")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.3.2")
}
