package com.example.code.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.code.R
import com.example.code.profile.ProfileActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            presenter.login(username.text.toString(), password.text.toString())
        }

    }

    override fun loginSuccess() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

    override fun loginFail() {
        showError(R.string.login_fail)
    }

    override fun missingFields() {
        showError(R.string.missing_fields)
    }

    private fun showError(msg: Int) {
        val builder = AlertDialog.Builder(this)
        builder
            .setMessage(msg)
            .setPositiveButton(R.string.ok, null)
            .show()
    }

}