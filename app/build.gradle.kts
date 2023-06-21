@file:Suppress("UnstableApiUsage")

import plugins.Version

plugins {
    alias(libs.plugins.android.application)
    id("plugins.app-common-config")
    id("plugins.compose")
    id("quality.ktlint")
}

android {
    namespace = "com.awilab.composingbuildsample"

    defaultConfig {
        applicationId = "com.awilab.composingbuildsample"
        versionCode = Version.versionCode
        versionName = Version.versionName

        targetSdk = Version.targetSdk
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.compose)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.bundles.androidx.test)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}
