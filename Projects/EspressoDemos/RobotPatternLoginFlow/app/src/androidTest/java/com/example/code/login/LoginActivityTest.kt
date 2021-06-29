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

    companion object {
        const val WRONG_EMAIL = "Wrong email"
        const val WRONG_PASSWORD = "Wrong password"

        const val CORRECT_EMAIL = "mail@example.com"

    }

    @get:Rule
    val activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java, true, false)

    @Test
    fun loginMissingEmailPassword() {
        launchScreen()
        login {
            setEmail(WRONG_EMAIL)
            setPassword(WRONG_PASSWORD)
            clickLogin()
            matchErrorText(string(R.string.login_fail))
        }
    }

    @Test
    fun loginMissingPassword() {
       /* launchScreen()
        login {
            setEmail(CORRECT_EMAIL)
            clickLogin()
            matchErrorText(string(R.string.login_fail))
        }*/
    }


    private fun launchScreen() {
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    private fun string(res: Int): String = activityRule.activity.getString(res)
}