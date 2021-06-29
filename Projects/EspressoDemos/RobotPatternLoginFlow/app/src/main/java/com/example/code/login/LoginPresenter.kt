package com.example.code.login

class LoginPresenter(var loginView: LoginView,
                     private val loginInteractor: LoginInteractor) : LoginInteractor.OnLoginFinishedListener{

    fun validateCredentials(username: String, password: String) {
        loginInteractor.login(username, password, this)
    }

    override fun onUsernameError() {
        loginView.apply { onUsernameError() }
    }

    override fun onPasswordError() {
        loginView.apply { onPasswordError() }
    }

    override fun onSuccess() {
        loginView.apply { onSuccess() }
    }


}