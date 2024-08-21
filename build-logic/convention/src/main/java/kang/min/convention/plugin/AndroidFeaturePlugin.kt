package kang.min.convention.plugin

import com.android.build.api.dsl.LibraryExtension
import kang.min.convention.DependencyUnitValue
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

internal class AndroidFeaturePlugin  : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("kangmingu.plugin.library")
                apply("kangmingu.plugin.library.compose")
                apply("kangmingu.plugin.hilt")
                apply("kangmingu.plugin.network")
            }

            extensions.configure<LibraryExtension> {
                sourceSets {
                    getByName("main") {
                        java {
                            manifest.srcFile("src/main/AndroidManifest.xml")
                        }
                    }
                }
            }

            dependencies {
                with(DependencyUnitValue) {
                    implementation(project(":core:domain"))
                    implementation(project(":core:model"))
                    implementation(project(":core:ui"))
                    implementation(project(":core:navigation"))
                }
            }
        }
    }
}