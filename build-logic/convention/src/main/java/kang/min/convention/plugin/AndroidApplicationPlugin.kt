package kang.min.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import kang.min.convention.DependencyUnitValue
import kang.min.convention.configuration.configBasicOption
import kang.min.convention.configuration.configureApplicationBuildType
import kang.min.convention.configuration.configureApplicationDefault
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<ApplicationExtension> {
                namespace = "kang.min.gu"

                configureApplicationDefault()
                configureApplicationBuildType()
                configBasicOption()

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }

            dependencies { // 의존성 library 세팅
                with(DependencyUnitValue) {
                    implementation(libs.findBundle("androidX").get())
                    implementation((libs.findBundle("android.ktx").get()))
                    implementation((libs.findLibrary("kotlin.serialization").get()))

                    testImplementation(libs.findLibrary("junit").get())

                    androidTestImplementation((libs.findBundle("test").get()))

                    debugImplementation (libs.findBundle("debug.test").get())
                }
            }
        }
    }
}