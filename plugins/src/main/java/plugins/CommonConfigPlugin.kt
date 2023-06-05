package plugins

import com.android.build.api.dsl.ApplicationExtension
import extension.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


class CommonConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                plugins.run {
                    apply("org.jetbrains.kotlin.android")
                }

                defaultConfig {
                    compileSdk = Version.compileSdk
                    minSdk = Version.minSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }

                packaging {
                    resources.excludes.apply {
                        add("META-INF/AL2.0")
                        add("META-INF/LGPL2.1")
                    }
                }

                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }
            }
        }
    }
}