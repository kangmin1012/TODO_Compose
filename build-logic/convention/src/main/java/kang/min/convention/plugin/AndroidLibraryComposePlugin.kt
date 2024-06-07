package kang.min.convention.plugin

import com.android.build.api.dsl.LibraryExtension
import kang.min.convention.configuration.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureAndroidCompose(extensions.getByType<LibraryExtension>())
        }
    }
}