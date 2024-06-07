plugins {
    id("kangmingu.plugin.library")
    id("kangmingu.plugin.hilt")
}

android {
    namespace = "kang.min.domain"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
}