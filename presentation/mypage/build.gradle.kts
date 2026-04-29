import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.presentation)
}

android {
    setNamespace("presentation.mypage")
}

dependencies {
    implementation(projects.domain.local)
}
