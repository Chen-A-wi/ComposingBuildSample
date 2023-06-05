@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.android.application)
    id("plugins.common-config")
    id("plugins.compose")
}

android {
    namespace = "com.awilab.composingbuildsample"

    defaultConfig {
        applicationId = "com.awilab.composingbuildsample"
        versionCode = 1
        versionName = "1.0"

        targetSdk = 33
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