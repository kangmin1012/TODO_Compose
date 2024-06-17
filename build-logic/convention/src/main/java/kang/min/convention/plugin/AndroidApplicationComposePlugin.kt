package kang.min.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import kang.min.convention.configuration.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            with(pluginManager) {
               apply(libs.findPlugin("composeCompiler").get().get().pluginId)
            }

            configureAndroidCompose(extensions.getByType<ApplicationExtension>())
        }
    }
}