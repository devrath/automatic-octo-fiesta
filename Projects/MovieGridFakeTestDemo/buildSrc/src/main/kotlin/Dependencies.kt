object Kotlin {
    const val standardLibrary = "1.4.32"
    const val coroutines = "1.3.9"
}

object Apps {
    const val compileSdk = 30
    const val minSdk = 16
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolsVersion = "30.0.3"
    const val applicationId = "com.example.code"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}


object BuildPlugins {
   object Versions {
        const val buildToolsVersion = "4.1.0"
        const val gradleVersion = "6.7"
        const val hilt = "2.35.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.standardLibrary}"
    const val androidHilt = "dagger.hilt.android.plugin"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
}


object Libraries {
    private object Versions {
        const val app_compat = "1.3.0"
        const val core_ktx = "1.5.0"
        const val constraint_layout = "2.0.4"
        const val material = "1.3.0"
        const val hilt = BuildPlugins.Versions.hilt
    }
    const val kotlin_std_lib      = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.standardLibrary}"
    const val app_compat         = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val core_ktx           = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val constraint_layout  = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material          = "com.google.android.material:material:${Versions.material}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
}

object AndroidTestLibraries {
    private object Versions {
        const val junit = "1.1.2"
        const val espresso_core = "3.3.0"
    }
    const val junit     = "androidx.test.ext:junit:${Versions.junit}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}