package extension

import ProjectVersions
import com.android.build.api.dsl.CommonExtension
import composeVersion
import org.gradle.api.artifacts.VersionCatalog

fun CommonExtension<*, *, *, *>.androidConfig() {
    defaultConfig {
        compileSdk = ProjectVersions.compileSdk
        minSdk = ProjectVersions.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

fun CommonExtension<*, *, *, *>.composeConfig(libs: VersionCatalog) {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.composeVersion
    }

    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}
