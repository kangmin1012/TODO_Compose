plugins {
    id("kangmingu.plugin.library")
    id("kangmingu.plugin.hilt")
}

android {
    namespace = "kang.min.datastore"
}

dependencies {
    implementation(libs.dataStore)
    implementation(project(":core:model"))
}