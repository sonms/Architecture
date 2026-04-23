import com.example.makersassignment.buildlogic.setNamespace

plugins {
   alias(libs.plugins.makersassignment.android.library)
   alias(libs.plugins.makersassignment.hilt)
   alias(libs.plugins.makersassignment.serialization)
}

android {
   setNamespace("core.di")
}

dependencies {
   implementation(libs.coil.compose)
   implementation(libs.androidx.datastore.preferences)
   implementation(libs.hilt)
   ksp(libs.hilt.compiler)
}
