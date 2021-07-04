package com.example.code.utils

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class RegistrationUtilTest {


    @Test
    fun `test when user name and password are empty validation returns false`() {
        // ARRANGE
        val userName = ""
        val password = ""
        val confirmPassword = ""
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isFalse()
    }


    @Test
    fun `test when user name is not from one of the registered users validation returns true`() {
        // ARRANGE
        val userName = "Sanjay"
        val password = "Password"
        val confirmPassword = "Password"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isTrue()
    }


    @Test
    fun `test when user name is among the list of registered users validation returns false`() {
        // ARRANGE
        val userName = "Mahesh"
        val password = "Password"
        val confirmPassword = "Password"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isFalse()
    }

    @Test
    fun `test if password length is less than or equal to five validation returns false`() {
        // ARRANGE
        val userName = "Mahesh"
        val password = "Pass"
        val confirmPassword = "Pass"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isFalse()
    }

    @Test
    fun `test if password length is more than five validation returns true`() {
        // ARRANGE
        val userName = "Mahesh"
        val password = "Password"
        val confirmPassword = "Password"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isFalse()
    }


    @Test
    fun `test if password and confirm password are both not same validation returns false`() {
        // ARRANGE
        val userName = "Mahesh"
        val password = "Password"
        val confirmPassword = "Pass"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isFalse()
    }

    @Test
    fun `test if password and confirm password are both same and validation returns true`() {
        // ARRANGE
        val userName = "Sanjay"
        val password = "Password"
        val confirmPassword = "Password"
        // ACT
        val sut = RegistrationUtil.validateRegistration(
            userName,password,confirmPassword
        )
        // ASSERT
        assertThat(sut).isTrue()
    }

}