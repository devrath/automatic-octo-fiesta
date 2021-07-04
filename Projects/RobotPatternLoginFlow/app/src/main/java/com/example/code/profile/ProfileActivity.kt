package com.example.code.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.code.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        intent.data?.let {
            Log.i("asd", "host: " + it.host)
            Log.i("asd", "q: " + it.query)
            it.queryParameterNames.forEach { Log.i("asd", "param: " + it) }
        }
    }
}