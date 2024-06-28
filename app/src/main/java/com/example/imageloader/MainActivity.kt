package com.example.imageloader

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.imageloader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUrl = "https://www.gastatic.com/webp/gallery/1.jpg"
        var gifUrl = "https://media.giphy.com/media/SFKcOy1EPQGZyAYST9/giphy.gif"

        Glide.with(this)
            .load(gifUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.image_error)
            .into(binding.imgView)
    }
}