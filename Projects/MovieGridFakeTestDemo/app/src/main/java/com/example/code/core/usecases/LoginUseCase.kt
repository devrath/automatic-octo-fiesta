package com.example.code.core.usecases

import com.example.code.models.User
import com.example.code.core.shared.SuspendUseCase
import com.example.code.core.shared.dispatcher.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import com.example.code.core.shared.Result
import java.lang.Exception
import kotlin.coroutines.resume

class LoginUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<HashMap<String, String>, Result<User>>(dispatcher) {

    override suspend fun execute(parameters: HashMap<String, String>): Result<User> =

        suspendCancellableCoroutine { coroutine ->

            try {
                var userName = parameters["userName"]
                var password = parameters["password"]

                coroutine.resume(Result.Success(User(userName = "SomeName")))
            }catch (ex:Exception) {
                coroutine.resume(Result.Error(ex))
            }

        }

}