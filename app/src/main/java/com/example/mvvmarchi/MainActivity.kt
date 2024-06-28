package com.example.mvvmarchi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmarchi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        loginViewModel.statusMessage.observe(this, Observer { message ->
            message?.let {
               // loginViewModel.onToastDisplayed()
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

    }
}