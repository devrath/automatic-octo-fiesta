package com.example.code.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.code.R
import com.example.code.settings.SettingsActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById<Button>(R.id.btnSettings).setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) }

        intent.data?.let {
            Log.i("asd", "host: " + it.host)
            Log.i("asd", "q: " + it.query)
            it.queryParameterNames.forEach { Log.i("asd", "param: " + it) }
        }
    }
}