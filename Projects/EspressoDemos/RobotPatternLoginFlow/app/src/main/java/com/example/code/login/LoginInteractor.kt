package com.example.code.login

class LoginInteractor {

    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        when {
            username.isEmpty() -> listener.onUsernameError()
            password.isEmpty() -> listener.onPasswordError()
            username == "mail@example.com" && password == "pass" -> listener.onSuccess()
        }
    }

}