import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.library)
    alias(libs.plugins.makersassignment.hilt)
    alias(libs.plugins.makersassignment.serialization)
}

android {
    setNamespace("core.network")
}

dependencies {
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.serialization.json)
}

