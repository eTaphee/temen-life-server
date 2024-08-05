plugins {
    id("life.temen.build.convention.library")
    id("life.temen.build.convention.spring-jpa")
}

dependencies {
    implementation(libs.database.mariadb)
    implementation(libs.springboot.starter.jpa)

    implementation(projects.src.domain.temenLifeDomain)
}
