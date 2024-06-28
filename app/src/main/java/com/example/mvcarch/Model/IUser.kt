package com.example.mvcarch.Model

interface IUser {
    fun getEmail(): String?
    fun getPassword(): String?
    fun isValid(): Int
}