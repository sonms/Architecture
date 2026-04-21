plugins {
    alias(libs.plugins.makersassignment.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.javax.inject)
}
