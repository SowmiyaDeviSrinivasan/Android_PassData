package com.example.passdata

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity(), FragmentB.OnDataPass {
    lateinit var getText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getText = findViewById(R.id.get_text_view)
        val getValue = intent.getStringExtra("key1")
        getText.text = getValue

        val bundle = Bundle().apply {
            putString("sendData",getText.getText().toString())
        }

        val targetFragment = FragmentA().apply{
            arguments = bundle
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,targetFragment)
            .commit()
    }

    override fun onDataPass(data: String) {
        getText.text = data
    }
}