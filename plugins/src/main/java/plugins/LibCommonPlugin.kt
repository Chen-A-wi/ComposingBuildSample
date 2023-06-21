package plugins

import com.android.build.api.dsl.LibraryExtension
import extension.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class LibCommonPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                plugins.run {
                    apply("org.jetbrains.kotlin.android")
                    apply("de.mannodermaus.android-junit5")
                    apply("quality.ktlint")
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

                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }

                packaging {
                    resources.excludes.apply {
                        add("META-INF/AL2.0")
                        add("META-INF/LGPL2.1")
                    }
                }
            }

            val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

            dependencies {
                "implementation"(libs.androidx.appcompat)
                "implementation"(libs.androidx.core)
                "implementation"(libs.androidx.lifecycle.runtime)


                //region Junit5
                "testImplementation"(libs.test.junit.api)
                "testRuntimeOnly"(libs.test.junit.jupiter.engine)
                //endregion

                "testImplementation"(libs.test.truth)
                "testImplementation"(libs.test.junit)
                "testRuntimeOnly"(libs.test.junit.vintage.engine)
                "androidTestImplementation"(libs.test.junit.ext)
                "androidTestImplementation"(libs.test.espresso.core)
            }
        }
    }
}