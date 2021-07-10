package com.example.code.features.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.example.code.Keys.VALID_PASSWORD
import com.example.code.Keys.VALID_USER_NAME
import com.example.code.R
import com.example.code.core.platform.BaseActivity
import com.example.code.databinding.ActivityLoginBinding
import com.example.code.features.profile.ProfileActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClickListeners()
        observeLiveData()
    }

    private fun setClickListeners() {
        binding.apply {
            login.setOnClickListener {
                viewModel.initiateLogin(binding.username.text.toString(), binding.password.text.toString())
            }
        }
    }

    private fun observeLiveData() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect {
                setViewState(it)
            }
        }
    }

    private fun setViewState(it: LoginViewState) {
        when(it){
            is LoginViewState.ViewStatePasswordEmpty -> showError(R.string.msg_password_empty)
            is LoginViewState.ViewStateNameEmpty -> showError(R.string.msg_username_empty)
            is LoginViewState.LoginInitialState -> screenInitialState()
            is LoginViewState.ViewStateException -> Toast.makeText(this@LoginActivity,it.exception,Toast.LENGTH_LONG).show()
            is LoginViewState.ViewStateIncorrectName -> showError(R.string.msg_username_incorrect)
            is LoginViewState.ViewStateIncorrectPassword -> showError(R.string.msg_password_incorrect)
            is LoginViewState.ViewStateSuccess -> successfulLogin()
        }
    }

    private fun screenInitialState() {
        binding.apply {
            username.setText(VALID_USER_NAME)
            password.setText(VALID_PASSWORD)
        }
    }

    private fun successfulLogin() {
        startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        finish()
    }

    private fun showError(msg: Int) {
        AlertDialog.Builder(this).setMessage(msg).setPositiveButton(R.string.ok, null).show()
    }

}