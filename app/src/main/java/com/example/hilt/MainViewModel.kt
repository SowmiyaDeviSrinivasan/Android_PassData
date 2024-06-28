package com.example.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
// @Inject, Hilt knows how to create an instance of that class
// by automatically resolving and providing its dependencies.
@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptoCurrencyRepository
) : ViewModel() {
    private val cryptocurrencyEmitter = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrency: LiveData<List<CryptoCurrency>> = cryptocurrencyEmitter
    init {
        loadCryptocurrency()
    }

    // getting cryptocurrencies list using
    // repository and passing it into live data
    private fun loadCryptocurrency() {
        cryptocurrencyEmitter.value = cryptocurrencyRepository.getCryptoCurrency()
    }
}