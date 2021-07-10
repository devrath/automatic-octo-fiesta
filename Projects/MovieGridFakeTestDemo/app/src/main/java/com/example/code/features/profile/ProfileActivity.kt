package com.example.code.features.profile

import android.content.Intent
import android.os.Bundle
import com.example.code.core.platform.BaseActivity
import com.example.code.databinding.ActivityProfileBinding
import com.example.code.features.movies.MoviesActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.apply {
            btnMovies.setOnClickListener {
                startActivity(Intent(this@ProfileActivity, MoviesActivity::class.java))
                finish()
            }
        }
    }
}