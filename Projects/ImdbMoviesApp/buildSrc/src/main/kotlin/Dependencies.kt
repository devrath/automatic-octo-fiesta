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
    //const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val testRunner = "com.example.code.utils.MockTestRunner"
}

object ProGuardFiles {
    const val shared_sdk = "consumer-rules.pro"
    const val network_sdk = "consumer-rules.pro"
}

object ScriptPlugins {
    const val infrastructure = "scripts.infrastructure"
    const val variants = "scripts.variants"
    const val quality = "scripts.quality"
    const val compilation = "scripts.compilation"
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

    const val androidLibrary = "com.android.library"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}


object Libraries {
    private object Versions {
        const val app_compat = "1.3.0"
        const val core_ktx = "1.5.0"
        const val constraint_layout = "2.0.4"
        const val material = "1.3.0"
        const val hilt = BuildPlugins.Versions.hilt
        const val glide = "4.11.0"
        const val retrofit = "2.9.0"
        const val okHttpLoggingInterceptor = "4.9.0"
        const val lifecycle = "2.2.0"
        const val lifecycleExtensions = "2.1.0"
        const val fragmentKtx = "1.3.5"


    }
    const val kotlin_std_lib      = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.standardLibrary}"
    const val app_compat         = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val core_ktx           = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val constraint_layout  = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material          = "com.google.android.material:material:${Versions.material}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val retrofit = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val mockitoKotlin = "2.1.0"
        const val mockitoInline = "3.6.0"
        const val mockitoCore = "3.6.0"
        const val coreTesting = "2.1.0"
        const val coroutinesTest = "1.5.0"
        const val mockServer = "4.9.1"
        const val googleTruth = "1.1.3"
    }
    const val junit4            = "junit:junit:${Versions.junit4}"
    const val mockitoKotlin     = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline     = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val mockitoCore       = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val coreTesting       = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutinesTest    = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val mockServer        = "com.squareup.okhttp3:mockwebserver:${Versions.mockServer}"
    const val googleTruthLib    = "com.google.truth:truth:${Versions.googleTruth}"
}

object AndroidTestLibraries {
    private object Versions {
        const val junit = "1.1.2"
        const val espresso_core = "3.3.0"
        const val testrules = "1.3.0"
        const val mockServer = "4.9.1"
        const val okhttp3IdlingResource = "1.0.0"
        const val hilt = BuildPlugins.Versions.hilt
        const val googleTruth = "1.1.3"
        const val testCoreKtx = "1.4.0"
    }
    const val junit                 = "androidx.test.ext:junit:${Versions.junit}"
    const val testrules             = "androidx.test:rules:${Versions.testrules}"
    const val testCoreKtx             = "androidx.test:core-ktx:${Versions.testCoreKtx}"
    const val espresso              = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val mockServer            = "com.squareup.okhttp3:mockwebserver:${Versions.mockServer}"
    const val idlingResource        = "com.jakewharton.espresso:okhttp3-idling-resource:${Versions.okhttp3IdlingResource}"
    const val hiltAndroidTesting    = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val googleTruthLib    = "com.google.truth:truth:${Versions.googleTruth}"
}

object KaptAndroidTest {
    private object Versions {
        const val hiltAndroidCompiler = "2.35.1"
    }
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}"
}