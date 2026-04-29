import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.data)
}

android {
    setNamespace("data.home")
}

dependencies {
    //core
    implementation(projects.core.common)

    //domain
    implementation(projects.domain.home)
}
