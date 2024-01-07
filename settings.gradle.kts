pluginManagement {
    repositories {
        google()
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

rootProject.name = "JetNewsApp"
include(":app")
include(":core:designSystem")
include(":core:preferences")
include(":core:network")
include(":core:database")
include(":feature:home")
include(":feature:bookmark")
