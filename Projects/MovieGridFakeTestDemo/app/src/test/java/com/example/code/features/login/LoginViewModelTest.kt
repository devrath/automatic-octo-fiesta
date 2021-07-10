package com.example.code.features.login

import com.example.code.base.BaseUnitTest
import com.example.code.core.shared.data
import com.example.code.core.usecases.LoginUseCase
import com.example.code.utils.runBlockingTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.example.code.core.shared.Result

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class LoginViewModelTest : BaseUnitTest() {


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
    fun `test if error in login`() = coroutineRule.runBlockingTest {
        val dispatcher = coroutineRule.testDispatcher
        val loginUseCase = LoginUseCase(dispatcher)

        val credentials = HashMap<String, String>()
        credentials["userName"] = "wrong@example.com"
        credentials["password"] = "pass"

        val result = loginUseCase.invoke(credentials)

        assertThat(result.data)
            .isEqualTo(Result.Success(LoginViewState.ViewStateIncorrectName))
    }



}