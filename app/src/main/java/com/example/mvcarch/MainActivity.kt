package com.example.mvcarch

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mvcarch.Controller.ILoginController
import com.example.mvcarch.Controller.LoginController
import com.example.mvcarch.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {
    var email: EditText? = null
    var password: EditText? = null
    var loginbtn: Button? = null
    var loginController: ILoginController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email_edit_txt)
        password = findViewById(R.id.pwd_edit_txt)
        loginbtn = findViewById(R.id.login_btn)
        loginController = LoginController(this)

        loginbtn?.setOnClickListener {
            (loginController as LoginController)
                .onLogin(email?.getText().toString().trim(),
                    password?.getText().toString().trim())
        }

    }

    override fun onLoginSuccess(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}