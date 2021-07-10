package com.example.code.features.login

sealed class LoginViewState {
    object LoginInitialState : LoginViewState()
    object ViewStateNameEmpty : LoginViewState()
    object ViewStatePasswordEmpty : LoginViewState()
    object ViewStateIncorrectName : LoginViewState()
    object ViewStateIncorrectPassword : LoginViewState()
    object ViewStateIncorrectNamePassword : LoginViewState()
    data class ViewStateSuccess(val username:String) : LoginViewState()
    data class ViewStateException(val exception:String) : LoginViewState()
}