package com.example.code.login

interface LoginView {
    fun onUsernamePwdError()
    fun onUsernameError()
    fun onPasswordError()
    fun onSuccess()
}