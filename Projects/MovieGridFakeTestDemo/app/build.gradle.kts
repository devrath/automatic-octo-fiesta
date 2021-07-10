plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.androidHilt)
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolsVersion)

    defaultConfig {
        applicationId(Apps.applicationId)
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode(Apps.versionCode)
        versionName(Apps.versionName)
        multiDexEnabled=true
        testInstrumentationRunner(Apps.testRunner)
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

    kaptAndroidTest(KaptAndroidTest.hiltAndroidCompiler)

    implementation(Libraries.kotlin_std_lib)
    implementation(Libraries.app_compat)
    implementation(Libraries.core_ktx)
    implementation(Libraries.constraint_layout)
    implementation(Libraries.material)
    implementation(Libraries.glide)
    implementation(Libraries.hilt)
    implementation(Libraries.retrofit)
    implementation(Libraries.okHttpLoggingInterceptor)
    implementation(Libraries.fragmentKtx)

    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)
    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.kotlinCoroutinesAndroid)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.mockitoInline)
    testImplementation(TestLibraries.mockitoCore)
    testImplementation(TestLibraries.coreTesting)
    testImplementation(TestLibraries.coroutinesTest)
    testImplementation(TestLibraries.mockServer)
    testImplementation(TestLibraries.googleTruthLib)

    androidTestImplementation(AndroidTestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.testrules)
    androidTestImplementation(AndroidTestLibraries.testCoreKtx)
    androidTestImplementation(AndroidTestLibraries.espresso)
    androidTestImplementation(AndroidTestLibraries.mockServer)
    androidTestImplementation(AndroidTestLibraries.idlingResource)
    androidTestImplementation(AndroidTestLibraries.hiltAndroidTesting)
    androidTestImplementation(AndroidTestLibraries.googleTruthLib)


}