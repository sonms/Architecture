import com.example.makersassignment.buildlogic.setNamespace

plugins {
    alias(libs.plugins.makersassignment.android.library)
}

android {
    setNamespace("core.navigation")
}
