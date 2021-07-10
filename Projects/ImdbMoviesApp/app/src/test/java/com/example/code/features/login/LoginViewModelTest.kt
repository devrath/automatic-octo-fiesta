package com.example.code.features.login

import com.example.code.base.BaseUnitTest
import com.example.code.core.usecases.LoginUseCase
import com.example.code.utils.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class LoginViewModelTest : BaseUnitTest() {


    @Test
    fun `test if successful login`() = coroutineRule.runBlockingTest {

        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "mail@example.com"
        credentials["password"] = "pass"

        val loginVM = LoginViewModel(loginUseCase)

        loginVM.initiateLogin(userName = "mail@example.com", password = "pass")

        val expectedValue = LoginViewState.ViewStateSuccess("mail@example.com")

        loginVM.viewState.collect {
            val resultValue = it as LoginViewState.ViewStateSuccess
            assertThat(expectedValue.username).isEqualTo(resultValue.username)
        }
    }

}