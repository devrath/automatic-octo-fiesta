package com.example.code.features.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.code.Keys
import com.example.code.Keys.VALID_PASSWORD
import com.example.code.Keys.VALID_USER_NAME
import com.example.code.R
import com.example.code.databinding.ActivityLoginBinding
import com.example.code.features.movies.MainActivity
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel : LoginViewModel by viewModels()

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            is LoginViewState.ViewStateIncorrectNamePassword -> showError(R.string.msg_username_password_incorrect)
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
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun showError(msg: Int) {
        val builder = AlertDialog.Builder(this)
        builder
            .setMessage(msg)
            .setPositiveButton(R.string.ok, null)
            .show()
    }

}