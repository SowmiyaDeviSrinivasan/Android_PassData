package com.example.mvcarch.View

interface ILoginView {
    fun onLoginSuccess(message: String?)
    fun onLoginError(message: String?)
}