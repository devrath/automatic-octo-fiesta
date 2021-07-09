package com.example.code.login

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.code.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var activityScenario: ActivityScenario<LoginActivity>

    @Before
    fun setUp() {
        launchActivityUnderTest()
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun checkForEmptyUserName() {

        launchActivityUnderTest()

        // ARRANGE
        val userName = ""
        val password = "pass"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(getString(R.string.username_error))
    }

    @Test
    fun checkForEmptyPassword() {
        // ARRANGE
        val userName = "mail@example.com"
        val password = ""

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(getString(R.string.password_error))
    }

    @Test
    fun check_scenario_when_user_name_is_invalid() {
        // ARRANGE
        val userName = "wrong@example.com"
        val password = "pass"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(getString(R.string.username_error))
    }

    @Test
    fun check_scenario_when_password_is_invalid() {
        // ARRANGE
        val userName = "mail@example.com"
        val password = "wrong password"

        // ACT
        actOnLogin(userName, password)

        // ASSERT
        assertOnErrorText(getString(R.string.password_error))
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
            matchText(R.id.tvName, getString(R.string.name_surname))
        }
    }

    private fun actOnLogin(userName: String, password: String) {
        login {
            setEmail(userName)
            setPassword(password)
            clickLogin()
        }
    }

    private fun assertOnErrorText(message: String) {
        login { matchErrorText(message) }
    }

    /**
     * Launch the screen
     */
    private fun launchActivityUnderTest() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), LoginActivity::class.java)
        activityScenario = launchActivity(intent)
    }

    private fun getString(res: Int): String = ApplicationProvider.getApplicationContext<Context>().getString(res)

}