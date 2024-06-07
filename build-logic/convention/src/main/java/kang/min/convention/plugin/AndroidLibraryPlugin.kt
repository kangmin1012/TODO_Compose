package kang.min.convention.plugin

import com.android.build.api.dsl.LibraryExtension
import kang.min.convention.DependencyUnitValue
import kang.min.convention.configuration.configBasicOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<LibraryExtension> {
                configBasicOption()

                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            dependencies {
                with(DependencyUnitValue) {
                    implementation(libs.findBundle("androidX").get())
                    implementation((libs.findBundle("android.ktx").get()))
                    implementation((libs.findLibrary("kotlin.serialization").get()))

                    testImplementation(libs.findLibrary("junit").get())

                    androidTestImplementation((libs.findBundle("test").get()))
                }
            }
        }
    }
}