package com.example.makersassignment.buildlogic

import org.gradle.api.Project

/**
 * 모듈의 네임스페이스를 설정합니다. (예: "com.example.makersassignment.presentation.home")
 */
fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.example.makersassignment.$name"
    }
}
