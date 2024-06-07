plugins {
    id("kangmingu.plugin.library")
    id("kangmingu.plugin.hilt")
    id("kangmingu.plugin.network")
}

android {
    namespace = "kang.min.network"
}

dependencies {
    implementation(project(":core:model"))
}