package com.example.code.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.code.R
import com.example.code.databinding.ActivityLoginBinding
import com.example.code.profile.ProfileActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding
    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            presenter.validateCredentials(binding.username.text.toString(), binding.password.text.toString())
        }

    }

    override fun onUsernamePwdError() {
        showError(R.string.username_pwd_error)
    }

    override fun onUsernameError() {
        showError(R.string.username_error)
    }

    override fun onPasswordError() {
        showError(R.string.password_error)
    }

    override fun onSuccess() {
        startActivity(Intent(this, ProfileActivity::class.java))
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