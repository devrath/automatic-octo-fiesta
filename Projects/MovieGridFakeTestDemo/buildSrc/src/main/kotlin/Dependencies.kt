const val kotlin_version = "1.4.32"

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


object Libraries {
    private object Versions {
        const val app_compat = "1.3.0"
        const val core_ktx = "1.5.0"
        const val constraint_layout = "2.0.4"
        const val material = "1.3.0"
    }
    const val kotlin_std_lib      = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    const val app_compat         = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val core_ktx           = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val constraint_layout  = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material          = "com.google.android.material:material:${Versions.material}"
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