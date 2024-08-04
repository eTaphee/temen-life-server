rootProject.name = "temen-life"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

includeBuild("src/module/temen-life-module-build-tool")
