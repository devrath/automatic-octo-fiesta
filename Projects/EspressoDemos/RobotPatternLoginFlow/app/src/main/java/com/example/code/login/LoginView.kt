package com.example.code.login

interface LoginView {
    fun onUsernameError()
    fun onPasswordError()
    fun onSuccess()
}