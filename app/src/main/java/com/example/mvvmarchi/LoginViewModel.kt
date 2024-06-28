package com.example.mvvmarchi

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _statusMessage = MutableLiveData<String>()
    val statusMessage: LiveData<String>
        get() = _statusMessage

    fun onLoginClicked() {
        if(TextUtils.isEmpty(username.value)){
            _statusMessage.value = "Please enter E-mail"
        } else if(!username.value.let { Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches()}){
            _statusMessage.value = "Please enter a valid E-mail"
        } else if(TextUtils.isEmpty(password.value)){
            _statusMessage.value = "Please enter Password"
        } else if(password.value?.length!! <= 6){
            _statusMessage.value = "Please enter Password greater than 6 character"
        } else _statusMessage.value = "Login Successful!"
    }

    fun onToastDisplayed() {
        _statusMessage.value = null
    }

}