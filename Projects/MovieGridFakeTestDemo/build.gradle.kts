// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version = "1.4.32"
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}