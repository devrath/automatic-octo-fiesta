package com.example.code.features.login

import android.util.Log
import com.example.code.core.platform.BaseViewModelTwo
import com.example.code.core.usecases.LoginUseCase
import com.example.code.core.utils.Resource
import com.example.code.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import com.example.shared.Result
import com.example.shared.data

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModelTwo<Unit>() {

    private val _viewStateGroupChannelList =
        MutableStateFlow<Resource<User>>(Resource.loading(null))
    val viewStateChannelList = _viewStateGroupChannelList

    override fun setupPrerequisites(params: Unit) = Unit


    fun initiateLogin(userName: String, password: String) {

        val credentials = HashMap<String,String>()
        credentials["userName"] = userName
        credentials["password"] = password

        launchUseCase(catchException {
           Log.d("Error",it.message.toString())
            _viewStateGroupChannelList.value = Resource.error("Try again")
        }) {
            when (val result = loginUseCase.invoke(credentials)) {
                is Result.Success -> {
                    val loggedInUser = result.value.data
                    _viewStateGroupChannelList.value = Resource.success(loggedInUser)
                }
                is Result.Error -> {
                    _viewStateGroupChannelList.value = Resource.error(msg="Error in login")
                }
            }
        }
    }


}