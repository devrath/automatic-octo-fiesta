package com.example.code.utils

object RegistrationUtil {

    private val registeredUsers = listOf("Mahesh","Suresh")


    /**
     * The registration is successful if
     * UserName and Password are not empty
     * UserName is not one of registered users
     * Password length is more than 5
     * Password and confirmedPassword are both same
     *
     */
    fun validateRegistration(
        userName : String,
        password : String,
        confirmedPassword : String
    ) : Boolean {

        if(userName.isEmpty() &&
            password.isEmpty() &&
            confirmedPassword.isEmpty()){
            return false
        }

        if(registeredUsers.contains(userName)){
            return false
        }

        if(password.length<=5){
            return false
        }

        if(password != confirmedPassword){
            return false
        }

        return true
    }


}