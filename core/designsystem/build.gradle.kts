import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.library)
    alias(libs.plugins.makersassignment.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(projects.core.type)
}
