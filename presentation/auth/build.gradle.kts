import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.presentation)
}

android {
    setNamespace("presentation.auth")
}

dependencies {
    // core
    implementation(projects.core.type)


    // domain
    implementation(projects.domain.local)
}
