plugins {
    id("life.temen.build.convention.application")
    id("life.temen.build.convention.spring-jpa")
    id("life.temen.build.convention.spring-security")
    id("life.temen.build.convention.spring-web")
}

dependencies {
    implementation(libs.spring.security.oauth2.client)
    implementation(libs.database.mariadb)
}
