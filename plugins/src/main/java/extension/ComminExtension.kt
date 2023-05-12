package extension

import CommonAndroidVersions
import com.android.build.api.dsl.CommonExtension

fun CommonExtension<*, *, *, *>.androidConfig() {
    defaultConfig {
        compileSdk = CommonAndroidVersions.compileSdk
        minSdk = CommonAndroidVersions.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
