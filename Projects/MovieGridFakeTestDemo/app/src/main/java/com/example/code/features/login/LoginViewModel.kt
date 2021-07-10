package com.example.code.features.login

import android.util.Log
import com.example.code.core.platform.BaseViewModelTwo
import com.example.code.core.shared.Result
import com.example.code.core.shared.data
import com.example.code.core.shared.updateOnSuccess
import com.example.code.core.usecases.LoginUseCase
import com.example.code.core.utils.Resource
import com.example.code.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModelTwo<Unit>() {

    private val _viewState = MutableStateFlow<LoginViewState>(LoginViewState.LoginInitialState)
    val viewState = _viewState

    override fun setupPrerequisites(params: Unit) = Unit

    fun initiateLogin(userName: String, password: String) {

        val credentials = HashMap<String, String>()
        credentials["userName"] = userName
        credentials["password"] = password

        launchUseCase(catchException {
            Log.d("Error", it.message.toString())
            _viewState.value = LoginViewState.ViewStateException(exception = "Validation Failed")
        }) {
            when (val result = loginUseCase.invoke(credentials)) {
                is Result.Success -> {
                    _viewState.value = result.value.data ?: LoginViewState.LoginInitialState
                }
                is Result.Error -> {
                    _viewState.value = LoginViewState.ViewStateException(exception = result.exception.message.toString())
                }
            }
        }
    }


}