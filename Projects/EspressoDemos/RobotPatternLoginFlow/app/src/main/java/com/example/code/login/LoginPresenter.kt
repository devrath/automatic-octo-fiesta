package com.example.code.login

class LoginPresenter(var view: LoginView) {

    fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (email == "mail@example.com" && password == "pass") view.loginSuccess() else view.loginFail()
        } else {
            view.missingFields()
        }
    }

}

interface LoginView {
    fun loginSuccess()
    fun loginFail()
    fun missingFields()
}