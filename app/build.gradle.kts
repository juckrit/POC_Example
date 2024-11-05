import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

plugins {
    id(libs.plugins.android.application.plugin.get().pluginId)
    id(libs.plugins.kotlin.android.plugin.get().pluginId)
    id(libs.plugins.kotlin.kapt.plugin.get().pluginId)
    id(libs.plugins.navSafeArgs.plugin.get().pluginId)
//    id(libs.plugins.dagger.hilt.plugin.get().pluginId)
//    id(libs.plugins.google.services.plugin.get().pluginId)
    id(libs.plugins.kotlin.parcelize.plugin.get().pluginId)
//    id(libs.plugins.firebase.crashlytic.plugin.get().pluginId)
//    id(libs.plugins.apollo.plugin.get().pluginId).version(libs.versions.apolloClientVersion)
    id(libs.plugins.kotlint.plugin.get().pluginId)
//    id(libs.plugins.paparazzi.plugin.get().pluginId)
    kotlin(libs.plugins.serialization.plugin.get().pluginId).version(libs.versions.kotlinVersion)
}

android {
    namespace = "com.kingpowerclick.poc_example"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kingpowerclick.poc_example"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kapt {
        correctErrorTypes = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        viewBinding = true
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    lint {
        disable.add("Instantiatable")
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
        this.resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
        this.resources.excludes.add("META-INF/*.kotlin_module")
        this.resources.excludes.add("META-INF/DEPENDENCIES")
        this.resources.excludes.add("META-INF/LICENSE")
        this.resources.excludes.add("META-INF/LICENSE.txt")
        this.resources.excludes.add("META-INF/license.txt")
        this.resources.excludes.add("META-INF/NOTICE")
        this.resources.excludes.add("META-INF/NOTICE.txt")
        this.resources.excludes.add("META-INF/notice.txt")
        this.resources.excludes.add("META-INF/ASL2.0")
        this.resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
    configurations.all {
        resolutionStrategy {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
    }
    ndkVersion = "21.3.6528147"
    setTestOptions(this)
}
fun setTestOptions(baseAppModuleExtension: BaseAppModuleExtension) {
    baseAppModuleExtension.testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}
dependencies {
    implementation(platform(libs.jetbrains.kotlin.kotlinBom))
    implementation(platform(libs.compose.bom))
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.retrofit.converterMoshi)
    implementation(libs.squareup.retrofit.converterGson)
    implementation(libs.squareup.moshi.moshiKotlin)
    implementation(libs.squareup.moshi.moshiKotlinCodegen)
    implementation(libs.squareup.retrofit.adapterRxjava2)
    implementation(libs.jetbrains.kotlin.kotlinReflect)
    implementation(libs.timber)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.lifecycleViewmodelKtx)
    implementation(libs.androidx.navigation.navigationUi)
    implementation(libs.androidx.navigation.navigationUiKtx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.google.android.material)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.navigationFragment)
    implementation(libs.androidx.navigation.navigationFragmentKtx)
    implementation(libs.androidx.navigation.navigationCompose)
//    implementation(libs.androidx.hilt.lifecycle.viewmodel)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore)
    implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesAndroid)
    implementation(libs.apollo.runtime)
    implementation(libs.apollo.api)
    implementation(libs.androidx.fragment.test)
    implementation(libs.google.code.gson)
    implementation(libs.detect.soft.keyboard.listener)
    implementation(libs.facebook.android.facebookAndroidSdk)
    implementation(platform(libs.google.firebase.firebaseBom))
    implementation(libs.google.firebase.firebaseAnalyticsKtx)
    implementation(libs.snowplow)
    implementation(libs.omise)
    implementation(libs.squareup.okhttp3.loggingInterceptor)
    implementation(libs.glide)
    implementation(libs.google.android.flexbox)
    implementation(libs.android.support.palatte)
    implementation(libs.androidx.hilt.common)
    implementation(libs.androidx.paging)
    implementation(libs.androidx.pagingCompose)
    implementation(libs.airbnb.android.epoxy.epoxyPaging3)
    implementation(libs.google.android.play.appUpdate)
    implementation(libs.google.android.play.reviewKtx)
    implementation(libs.adjust.sdk)
    implementation(libs.android.installreferrer)
    implementation(libs.google.android.gms.playServicesAdsIdentifier)
    implementation(libs.google.firebase.firebaseCrashlytics)
    implementation(libs.oneTrust)
    implementation(libs.androidx.security)
//    implementation(libs.expandableLayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.jetbrains.kotlinx.kotlinxSerializationJson)
    implementation(libs.smartlook)
    implementation(libs.google.firebase.firebaseConfig)
    implementation(libs.google.firebase.firebaseMessagingKtx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.ui.graphics)
    implementation(libs.androidx.constraintLayoutCompose)
    implementation(libs.coil.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.customView)
    implementation(libs.androidx.customViewPoolingcontainer)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.material3WindowSizeClass)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.ui.test.manifest)
    implementation(libs.airbnb.android.epoxy)
    implementation(libs.google.android.gms.playServicesAuthApiPhone)
    implementation(libs.facebook.android.facebookLogin)
    implementation(libs.airbnb.android.lottie)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.core.splashScreen)
    implementation(libs.google.android.play.appUpdateKtx)
    implementation(libs.androidx.browser)
    implementation(libs.permissionsDispatcher)
    implementation(libs.google.android.material.composeThemeAdapter)
    implementation(libs.google.accompanist.accompanisAappcompatTheme)
    implementation(libs.lokalise) {
        isTransitive = true
    }
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.animation)
    implementation(libs.androidx.lifecycle.lifecycleViewmodelCompose)
    implementation(libs.androidx.lifecycle.lifecycleRuntimeCompose)
    implementation(libs.gravitysnaphelper)
    implementation(libs.easyFlipView)
    implementation(libs.flippable)
    implementation(libs.youtubePlayer)
//    implementation(libs.photoview)
//    implementation(libs.saleforceMarketingCloud)

    kapt(libs.airbnb.android.epoxy.epoxyProcessor)
    kapt(libs.google.dagger.hiltCompiler)
    kapt(libs.google.dagger.hiltAndroid)
    kapt(libs.androidx.lifecycle.common.java8)
    kapt(libs.jetbrains.kotlinx.kotlinxMetadataJvm)

    loadTestDependencies(this)
    loadAndroidTestDependencies(this)

}

fun loadTestDependencies(dependencyHandlerScope: DependencyHandlerScope) {
    dependencyHandlerScope {
        testImplementation(libs.byte.buddy.agent)
        testImplementation(libs.byte.buddy.android)
        testImplementation(libs.mockito.core)
        testImplementation(libs.mockito.inline)
        testImplementation(libs.mockk.agent)
        testImplementation(libs.mockk.android) {
            exclude("io.mockk", "mockk-agent-jvm")
        }
        testImplementation(libs.robolectric)
        testImplementation(libs.junit)
        testImplementation(libs.google.truth)
        testImplementation(libs.jetbrains.kotlinx.kotlinxCoroutinesTest)
        testImplementation(libs.androidx.test.rules)
        testImplementation(libs.androidx.test.runner)
        testImplementation(libs.androidx.test.espresso.espressoCore)
        testImplementation(libs.androidx.test.ext.junit)
        testImplementation(libs.androidx.arch.core.coreTesting)
        testImplementation(libs.lokalise) {
            isTransitive = true
        }
        testImplementation(libs.google.dagger.hiltAndroid) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
        testImplementation(libs.google.dagger.hiltAndroidTesting) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
        kaptTest(libs.google.dagger.hiltAndroidCompiler) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
    }
}

fun loadAndroidTestDependencies(dependencyHandlerScope: DependencyHandlerScope) {
    dependencyHandlerScope {
        androidTestImplementation(libs.byte.buddy.agent)
        androidTestImplementation(libs.byte.buddy.android)
        androidTestImplementation(libs.mockito.core)
        androidTestImplementation(libs.mockito.inline)
        androidTestImplementation(libs.mockk.agent) {
            exclude("io.mockk", "mockk-agent-jvm")
        }
        androidTestImplementation(libs.compose.ui.test.junit)
        androidTestImplementation(libs.compose.ui.test.manifest)
        androidTestImplementation(libs.androidx.test.espresso.espressoCore)
        androidTestImplementation(libs.androidx.test.ext.junit)
        androidTestImplementation(libs.junit)
        androidTestImplementation(libs.google.truth)
        androidTestImplementation(libs.jetbrains.kotlinx.kotlinxCoroutinesTest)
        androidTestImplementation(libs.androidx.arch.core.coreTesting)
        androidTestImplementation(libs.androidx.test.rules)
        androidTestImplementation(libs.androidx.test.runner)
        androidTestImplementation(libs.lokalise) {
            isTransitive = true
        }
        androidTestImplementation(libs.mockk.android) {
            exclude("io.mockk", "mockk-agent-jvm")
        }
        androidTestImplementation(libs.google.dagger.hiltAndroid) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
        androidTestImplementation(libs.google.dagger.hiltAndroidTesting) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
        kaptAndroidTest(libs.google.dagger.hiltAndroidCompiler) {
            exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
        }
    }
}