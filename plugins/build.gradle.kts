plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.gradle.tools.build)
    implementation(libs.kotlin.gradle.plugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("AppCommonConfig") {
            id = "plugins.app-common-config"
            implementationClass = "plugins.AppCommonPlugin"
        }
        create("Compose") {
            id = "plugins.compose"
            implementationClass = "plugins.ComposePlugin"
        }
        create("Ktlint") {
            id = "quality.ktlint"
            implementationClass = "quality.KtlintPlugin"
        }
    }
}