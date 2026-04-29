import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.data)
}

android {
    setNamespace("data.local")
}

dependencies {
    // domain
    implementation(projects.domain.local)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
}
