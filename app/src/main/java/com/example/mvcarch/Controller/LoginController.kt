package com.example.mvcarch.Controller

import com.example.mvcarch.Model.User
import com.example.mvcarch.View.ILoginView

class LoginController(private val loginView: ILoginView): ILoginController {

    override fun onLogin(email: String?, password: String?) {
        val user = User(email, password)
        val loginCode = user.isValid()

        when(loginCode){
            0 -> loginView.onLoginError("Please enter Email")
            1 -> loginView.onLoginError("Please enter a valid Email")
            2 -> loginView.onLoginError("Please enter Password")
            3 -> loginView.onLoginError("Please enter Password greater than 6 characters")
            else -> loginView.onLoginSuccess("Login Successful")
        }
    }
}