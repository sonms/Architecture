import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    // kotlin-dsl이 내부적으로 kotlin.jvm을 포함하고 있어
    // 그래서 따로 선언 불필요
}

group = "com.example.makersassignment.buildlogic"
// 이 build-logic의 그룹 ID
// Convention Plugin들을 묶는 네임스페이스 역할

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_11)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
    // compileOnly인 이유:
    // 런타임엔 필요없고 Convention Plugin 코드 작성할 때만 필요해서
}

gradlePlugin {
    plugins {
        // app 모듈용
        register("androidApplication") {
            id = "makersassignment.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        // 일반 library용
        register("androidLibrary") {
            id = "makersassignment.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        // Compose 설정용
        register("androidCompose") {
            id = "makersassignment.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        // presentation(feature) 모듈용
        register("androidPresentation") {
            id = "makersassignment.android.presentation"
            implementationClass = "AndroidPresentationConventionPlugin"
        }
        // data 모듈용
        register("androidData") {
            id = "makersassignment.android.data"
            implementationClass = "AndroidDataConventionPlugin"
        }
        // domain 모듈용
        register("kotlinJvm") {
            id = "makersassignment.kotlin.jvm"
            implementationClass = "KotlinJvmConventionPlugin"
        }
        // Hilt 설정용
        register("hilt") {
            id = "makersassignment.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        // Serialization용
        register("serialization") {
            id = "makersassignment.serialization"
            implementationClass = "SerializationConventionPlugin"
        }
        // Test 설정용
        register("androidTest") {
            id = "makersassignment.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
    }
}
