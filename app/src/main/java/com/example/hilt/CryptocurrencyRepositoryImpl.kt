package com.example.hilt

class CryptocurrencyRepositoryImpl : CryptoCurrencyRepository{
    // Overriding the interface method and
    // providing implementation to it
    override fun getCryptoCurrency() = listOf(
        // here we are adding images from wikipedia
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Ethereum_logo_translucent.svg/1200px-Ethereum_logo_translucent.svg.png", "Ethereum"),
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Binance_logo.svg/1920px-Binance_logo.svg.png", "Binance"),
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/en/d/d0/Dogecoin_Logo.png", "DogeCoin"),
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Litecoin_Logo.jpg/2048px-Litecoin_Logo.jpg", "LiteCoin"),
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/commons/5/56/Stellar_Symbol.png", "Stellar"),
        CryptoCurrency("https://upload.wikimedia.org/wikipedia/commons/5/59/Polkadot_Logotype_color.png", "Polkadot"),
    )
}