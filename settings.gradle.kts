pluginManagement {
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
        maven {
            setUrl("https://maven.lokalise.com")
        }
        maven {
            setUrl("https://jitpack.io")
        }
        maven {
            setUrl("https://sdk.smartlook.com/android/release")
        }
        maven {
            setUrl("https://salesforce-marketingcloud.github.io/MarketingCloudSDK-Android/repository")
        }
    }
}

rootProject.name = "POC_Example"
include(":app")
 