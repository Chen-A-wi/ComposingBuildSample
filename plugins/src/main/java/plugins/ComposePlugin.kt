package plugins

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = Version.composeCompiler
                }

                val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

                dependencies {
                    "implementation"(libs.bundles.compose)
                    "androidTestImplementation"(libs.compose.ui.test.junit4)
                    "androidTestImplementation"(platform(libs.compose.bom))
                    "debugImplementation"(libs.compose.ui.tooling)
                    "debugImplementation"(libs.compose.ui.test.manifest)
                }
            }
        }
    }
}