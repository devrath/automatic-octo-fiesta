package com.example.code.login

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.code.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java, true, false)


    @Test
    fun checkForEmptyUserName() {

        // ARRANGE
        val userName = ""
        val password = "pass"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(string(R.string.username_error))
    }

    @Test
    fun checkForEmptyPassword() {
        // ARRANGE
        val userName = "mail@example.com"
        val password = ""

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(string(R.string.password_error))
    }

    @Test
    fun check_scenario_when_user_name_is_invalid() {
        // ARRANGE
        val userName = "wrong@example.com"
        val password = "pass"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(string(R.string.username_error))
    }

    @Test
    fun check_scenario_when_password_is_invalid() {
        // ARRANGE
        val userName = "mail@example.com"
        val password = "wrong password"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(string(R.string.password_error))
    }

    @Test
    fun check_scenario_for_successful_login() {
        // ARRANGE
        val userName = "mail@example.com"
        val password = "pass"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        login {
            matchText(R.id.tvName, string(R.string.name_surname))
        }
    }

    private fun actOnLogin(userName: String, password: String) {
        login {
            launchScreen()
            setEmail(userName)
            setPassword(password)
            clickLogin()
        }
    }

    private fun assertOnErrorText(message: String) {
        login { matchErrorText(message) }
    }

    private fun launchScreen() {
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    private fun string(res: Int): String = activityRule.activity.getString(res)
}