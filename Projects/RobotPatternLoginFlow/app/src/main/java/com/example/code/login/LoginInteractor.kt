package com.example.code.login

class LoginInteractor {

    companion object {
        const val VALID_USER_NAME = "mail@example.com"
        const val VALID_PASSWORD = "pass"
    }

    interface OnLoginFinishedListener {
        fun onUsernamePwdError()
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        when {
            username.isEmpty() -> listener.onUsernameError()
            password.isEmpty() -> listener.onPasswordError()
            username != VALID_USER_NAME && password != VALID_PASSWORD -> listener.onUsernamePwdError()
            username != VALID_USER_NAME -> listener.onUsernameError()
            password != VALID_PASSWORD -> listener.onPasswordError()
            username == VALID_USER_NAME && password == VALID_PASSWORD -> listener.onSuccess()
        }
    }

}