plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    compileOnly(libs.androidGradlePlugin)
    compileOnly(libs.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "kangmingu.plugin.application"
            implementationClass = "kang.min.convention.plugin.AndroidApplicationPlugin"
        }

        register("AndroidLibraryPlugin") {
            id = "kangmingu.plugin.library"
            implementationClass = "kang.min.convention.plugin.AndroidLibraryPlugin"
        }

        register("AndroidApplicationComposePlugin") {
            id = "kangmingu.plugin.application.compose"
            implementationClass = "kang.min.convention.plugin.AndroidApplicationComposePlugin"
        }

        register("AndroidLibraryComposePlugin") {
            id = "kangmingu.plugin.library.compose"
            implementationClass = "kang.min.convention.plugin.AndroidLibraryComposePlugin"
        }

        register("HiltPlugin") {
            id = "kangmingu.plugin.hilt"
            implementationClass = "kang.min.convention.plugin.HiltPlugin"
        }

        register("NetworkPlugin") {
            id = "kangmingu.plugin.network"
            implementationClass = "kang.min.convention.plugin.NetworkPlugin"
        }
    }
}