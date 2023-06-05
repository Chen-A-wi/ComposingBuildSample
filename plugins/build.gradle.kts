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
}

gradlePlugin {
    plugins {
        create("CommonConfig") {
            id = "plugins.common-config"
            implementationClass = "plugins.CommonConfigPlugin"
        }
        create("Compose") {
            id = "plugins.compose"
            implementationClass = "plugins.ComposePlugin"
        }
    }
}