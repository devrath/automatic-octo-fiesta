package com.example.code.features.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.code.R
import com.example.code.core.utils.onFailure
import com.example.code.core.utils.onSuccess
import com.example.code.databinding.ActivityLoginBinding
import kotlinx.coroutines.flow.collect

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel : LoginViewModel by viewModels()

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            viewModel.initiateLogin(binding.username.text.toString(), binding.password.text.toString())
        }


        observeLiveData()

    }

    private fun observeLiveData() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewStateChannelList.collect {
                it.onSuccess { value ->

                }
                it.onFailure {

                }
            }
        }
    }

}