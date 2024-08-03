package kang.min.convention.configuration

import com.android.build.api.dsl.CommonExtension
import kang.min.convention.DependencyUnitValue
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        buildFeatures {
            compose = true
        }

        extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
            enableStrongSkippingMode.set(true)
            includeSourceInformation.set(true)

            reportsDestination.set(
                layout.buildDirectory.dir("compose_compiler")
            )
        }

        dependencies {
            DependencyUnitValue.implementation(libs.findLibrary("androidx.activity.compose").get())
            val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
            DependencyUnitValue.implementation(composeBom)
            DependencyUnitValue.implementation(libs.findBundle("compose").get())
            DependencyUnitValue.implementation(libs.findLibrary("compose.navigation").get())

            DependencyUnitValue.androidTestImplementation(composeBom)
            DependencyUnitValue.debugImplementation(libs.findBundle("debug.test").get())
        }
    }
}