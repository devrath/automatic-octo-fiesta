package com.example.code.core.usecases

import com.example.code.models.User
import com.example.code.core.shared.SuspendUseCase
import com.example.code.core.shared.dispatcher.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import com.example.code.core.shared.Result
import com.example.code.features.login.LoginViewState
import java.lang.Exception
import kotlin.coroutines.resume

class LoginUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<HashMap<String, String>, Result<LoginViewState>>(dispatcher) {

    companion object {
        const val VALID_USER_NAME = "mail@example.com"
        const val VALID_PASSWORD = "pass"
    }

    override suspend fun execute(parameters: HashMap<String, String>): Result<LoginViewState> =

        suspendCancellableCoroutine { coroutine ->

            try {
                val userName = parameters["userName"]
                val password = parameters["password"]

                if (userName != null && password != null) {
                    when {
                        userName.isEmpty() -> coroutine.resume(Result.Success(LoginViewState.ViewStateNameEmpty))
                        password.isEmpty() -> coroutine.resume(Result.Success(LoginViewState.ViewStatePasswordEmpty))
                        userName != VALID_USER_NAME -> coroutine.resume(Result.Success(LoginViewState.ViewStateIncorrectName))
                        password != VALID_PASSWORD -> coroutine.resume(Result.Success(LoginViewState.ViewStateIncorrectPassword))
                        userName != VALID_USER_NAME && password != VALID_PASSWORD -> coroutine.resume(Result.Success(LoginViewState.ViewStateIncorrectNamePassword))
                        userName == VALID_USER_NAME && password == VALID_PASSWORD -> coroutine.resume(Result.Success(LoginViewState.ViewStateSuccess(username = userName)))
                    }
                }
            }catch (ex:Exception) {
                coroutine.resume(Result.Error(ex))
            }

        }


}