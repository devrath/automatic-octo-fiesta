package com.example.code.utils

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import com.example.code.BuildConfig
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class OkHttpIdlingResourceRule: TestRule {

    private val resource : IdlingResource = OkHttp3IdlingResource.create("okhttp", createClient())

    override fun apply(base: Statement, description: Description): Statement {
        return object: Statement() {
            override fun evaluate() {
                IdlingRegistry.getInstance().register(resource)
                base.evaluate()
                IdlingRegistry.getInstance().unregister(resource)
            }
        }
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }
}