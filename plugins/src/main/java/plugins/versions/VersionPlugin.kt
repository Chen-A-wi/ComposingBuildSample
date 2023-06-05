package plugins.versions

import com.android.build.api.dsl.ApplicationExtension
import extension.androidConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class VersionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                androidConfig()
            }
        }
    }
}