plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode(Apps.versionCode)
        versionName(Apps.versionName)
        testInstrumentationRunner(Apps.testRunner)
        consumerProguardFiles(ProGuardFiles.network_sdk)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled=false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions { kotlinOptions.jvmTarget = "1.8" }
    buildFeatures { viewBinding=true }
}

dependencies {

    kapt(Libraries.hiltCompiler)
    kapt(Libraries.lifecycleCompiler)

    implementation(Libraries.kotlin_std_lib)
    implementation(Libraries.app_compat)
    implementation(Libraries.core_ktx)
    implementation(Libraries.material)
    implementation(Libraries.hilt)
    implementation(Libraries.retrofit)
    implementation(Libraries.okHttpLoggingInterceptor)

    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.kotlinCoroutinesAndroid)

}