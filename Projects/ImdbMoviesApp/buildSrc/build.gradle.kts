object Dependencies {
    const val AndroidBuildTools = "com.android.tools.build:gradle:4.1.0"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32"
    const val slaslasla = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.14.1"
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    jcenter()
    google()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation(Dependencies.AndroidBuildTools)
    implementation(Dependencies.kotlinGradlePlugin)
    implementation(Dependencies.detektGradlePlugin)
}