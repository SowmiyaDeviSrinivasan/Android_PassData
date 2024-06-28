package com.example.mvparch.Model

import android.text.TextUtils
import android.util.Patterns
import com.example.mvparch.Presenter.ILoginPresenter
import com.example.mvparch.View.ILoginView

class LoginModel(var loginView: ILoginView): ILoginPresenter {
    override fun doLogin(email: String?, password: String?) {
        if(TextUtils.isEmpty(email)){
            loginView.onLoginError("Please enter E-mail")
        }
        else if(!email?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() }!!){
            loginView.onLoginError("Please enter a valid E-mail")
        }
        else if(TextUtils.isEmpty(password)){
            loginView.onLoginError("Please enter Password")
        }
        else if(password?.length!! <= 6){
            loginView.onLoginError("Please enter Password greater than 6 character")
        } else loginView.onLoginSuccess("Login Successful!")
    }
}