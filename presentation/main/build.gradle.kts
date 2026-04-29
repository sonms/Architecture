import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.presentation)
}

android {
    setNamespace("presentation.main")
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // core
    implementation(projects.core.network)

    // feature
    implementation(projects.presentation.home)
    implementation(projects.presentation.auth)
    implementation(projects.presentation.mypage)
}
