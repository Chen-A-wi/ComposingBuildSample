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

    }
}