package kang.min.convention.plugin

import kang.min.convention.DependencyUnitValue
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                DependencyUnitValue.implementation(libs.findLibrary("hilt").get())
                DependencyUnitValue.kapt(libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}