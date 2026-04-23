pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MakersAssignment"
include(":app")

// core
include(":core:common")
include(":core:designsystem")
include(":core:navigation")
include(":core:type")
include(":core:di")
include(":core:network")

// data
include(":data:local")
include(":data:home")

// domain
include(":domain:local")
include(":domain:home")

// presentation
include(":presentation:auth")
include(":presentation:home")
include(":presentation:main")
include(":presentation:mypage")
