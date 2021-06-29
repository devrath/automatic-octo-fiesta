package com.example.code.login

import com.example.code.R
import com.example.code.base.BaseTestRobot

fun login(func : LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : BaseTestRobot() {

    fun setEmail(email: String) = fillEditText(R.id.username, email);

    fun setPassword(pass: String) = fillEditText(R.id.password, pass)

    fun clickLogin() = clickButton(R.id.login)

    fun matchErrorText(err: String) = matchText(textView(android.R.id.message), err)

}