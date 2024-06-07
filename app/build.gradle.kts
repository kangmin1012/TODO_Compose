plugins {
    id("kangmingu.plugin.application")
    id("kangmingu.plugin.application.compose")
    id("kangmingu.plugin.hilt")
    id("kangmingu.plugin.network")
}

dependencies {
    implementation(project(":core:ui"))
}
