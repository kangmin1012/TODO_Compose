package kang.min.convention.plugin

import kang.min.convention.DependencyUnitValue
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class NetworkPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                with(DependencyUnitValue) {
                    implementation(platform(libs.findLibrary("retrofit.bom").get()))
                    implementation(platform(libs.findLibrary("okhttp.bom").get()))
                    implementation(libs.findBundle("network").get())
                }
            }
        }
    }
}