import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.composeVersion: String
    get() = findVersion("composeCompiler").get().requiredVersion

object ProjectVersions {
    const val compileSdk = 33
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val minSdk = 24
}