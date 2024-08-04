import java.nio.file.FileVisitOption
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import kotlin.io.path.absolute

rootProject.name = "temen-life"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

fun includeModule(entryPointName: String) {
    val entryPoint = rootDir.resolve(entryPointName).toPath()

    println(entryPoint)

    val foundBuildScriptPaths = mutableListOf<Path>()
    Files.walkFileTree(
        entryPoint,
        setOf(FileVisitOption.FOLLOW_LINKS),
        Integer.MAX_VALUE,
        FileVisitor("build.gradle.kts", foundBuildScriptPaths),
    )

    val modules =
        foundBuildScriptPaths
            .map { it.parent.absolute().toString() }
            .map { it.replace("${rootDir.toPath()}${File.separator}", "") }
            .map { it.replace(File.separator, ":") }
            .filter { !it.contains("temen-life-module-build-tool") }
            .toList()

    include(*modules.toTypedArray())

    val moduleGroups =
        Files
            .list(entryPoint)
            .map { it.fileName.toString() }
            .map { "$entryPointName:$it" }
            .toList()

    include(*moduleGroups.toTypedArray())
}

class FileVisitor(
    private val fileNameToSearch: String,
    private val foundBuildScriptPaths: MutableList<Path>,
) : SimpleFileVisitor<Path>() {
    override fun visitFile(
        file: Path,
        attrs: java.nio.file.attribute.BasicFileAttributes,
    ): FileVisitResult {
        if (file.fileName.toString() == fileNameToSearch) {
            foundBuildScriptPaths.add(file.toAbsolutePath())
        }
        return FileVisitResult.CONTINUE
    }

    override fun visitFileFailed(
        file: Path,
        exc: java.io.IOException,
    ): FileVisitResult {
        println("Error accessing file: $file - ${exc.message}")
        return FileVisitResult.CONTINUE
    }

    override fun postVisitDirectory(
        dir: Path,
        exc: java.io.IOException?,
    ): FileVisitResult = FileVisitResult.CONTINUE

    override fun preVisitDirectory(
        dir: Path,
        attrs: java.nio.file.attribute.BasicFileAttributes,
    ): FileVisitResult = FileVisitResult.CONTINUE
}

includeBuild("src/module/temen-life-module-build-tool")
includeModule("src")
