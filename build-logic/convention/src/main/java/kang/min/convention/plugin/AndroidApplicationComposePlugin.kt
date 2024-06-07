package kang.min.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import kang.min.convention.configuration.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroidCompose(extensions.getByType<ApplicationExtension>())
        }
    }
}