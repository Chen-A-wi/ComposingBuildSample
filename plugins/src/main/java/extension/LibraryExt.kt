package extension

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.proguardConfig() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
        }
    }
}
