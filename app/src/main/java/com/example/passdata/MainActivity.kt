package com.example.passdata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var sendButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.send_txt_view)
        sendButton = findViewById(R.id.send_button)

        val getIntent = intent.getStringExtra("key1")

        if(getIntent != null)
        {
            textView.text = getIntent
        }
        sendButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                putExtra("key1", textView.getText().toString())
            }
            startActivity(intent)
        }
    }
}