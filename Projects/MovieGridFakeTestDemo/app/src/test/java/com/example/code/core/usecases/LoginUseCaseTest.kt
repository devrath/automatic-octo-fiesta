package com.example.code.core.usecases

import com.example.code.base.BaseUnitTest
import com.example.code.core.shared.Result
import com.example.code.core.shared.data
import com.example.code.features.login.LoginViewState
import com.example.code.utils.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class LoginUseCaseTest  : BaseUnitTest() {

    @Test
    fun `test if successful login`() = coroutineRule.runBlockingTest  {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "mail@example.com"
        credentials["password"] = "pass"

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStateSuccess("mail@example.com")))
    }

    @Test
    fun `test if user-name is incorrect`() = coroutineRule.runBlockingTest {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "wrong@example.com"
        credentials["password"] = "pass"

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStateIncorrectName))
    }

    @Test
    fun `test if password is incorrect`() = coroutineRule.runBlockingTest {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "mail@example.com"
        credentials["password"] = "wrong-password"

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStateIncorrectPassword))
    }


    @Test
    fun `test if user-name is empty`() = coroutineRule.runBlockingTest {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = ""
        credentials["password"] = "wrong-password"

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStateNameEmpty))
    }

    @Test
    fun `test if password is empty`() = coroutineRule.runBlockingTest {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "mail@example.com"
        credentials["password"] = ""

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStatePasswordEmpty))
    }

}