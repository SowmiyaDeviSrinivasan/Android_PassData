package com.example.retrofit

import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.Adapters.RecyclerViewAdapter
import com.example.retrofit.Models.UsersItem
import com.example.retrofit.Utils.RetrofitInstance
import com.example.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var userLists: List<UsersItem>
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userLists = listOf()

        GlobalScope.launch(Dispatchers.IO) {
            val response = try{
                RetrofitInstance.api.getAllUsers()
        }catch (e:IOException){
            Toast.makeText(applicationContext, "App Error ${e.message}", Toast.LENGTH_SHORT).show()
            return@launch
        }catch (e: HttpException){
                Toast.makeText(applicationContext, "Http Error ${e.message}", Toast.LENGTH_SHORT).show()
                return@launch
        }

            if(response.isSuccessful && response.body() != null){
                withContext(Dispatchers.Main){
                    userLists = response.body()!!
                    binding.recylerView.apply {
                        recyclerViewAdapter = RecyclerViewAdapter(userLists)
                        adapter = recyclerViewAdapter
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }
        }
    }
}
