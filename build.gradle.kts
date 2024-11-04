
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.classpath.android.gradle.plugin)
        classpath(libs.classpath.kotlin.gradle.plugin)
        classpath(libs.classpath.navigation.args)
        classpath(libs.classpath.hilt)
//        classpath(libs.classpath.google.services)
//        classpath(libs.classpath.crashlytics)
//        classpath(libs.classpath.paparazzi)
//        classpath(libs.classpath.jacoco)
        classpath(libs.classpath.ktlint.compose.rules)
    }
}

plugins {
    alias(libs.plugins.kotlint.plugin) apply false
    id(
        libs.plugins.jacoco.plugin
            .get()
            .pluginId,
    )
}



