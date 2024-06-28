package com.example.hilt

interface CryptoCurrencyRepository {

    fun getCryptoCurrency(): List<CryptoCurrency>
}