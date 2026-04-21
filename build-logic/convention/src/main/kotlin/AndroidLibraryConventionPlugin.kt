import com.example.makersassignment.buildlogic.androidExtension
import com.example.makersassignment.buildlogic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 일반 Android Library 모듈용 Convention Plugin
 * core:common, core:designsystem, core:navigation, core:type 에서 사용
 *
 * 적용되는 설정:
 * - com.android.library
 * - org.jetbrains.kotlin.android
 * - compileSdk, minSdk, JVM 11 (configureKotlinAndroid 헬퍼)
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            /*extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }*/
            configureKotlinAndroid(androidExtension)
        }
    }
}
