package com.harjot.projectviewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.harjot.projectviewbinding.databinding.ActivityAfterLoginBinding
import com.harjot.projectviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    lateinit var etEmail: EditText
//    lateinit var etPassword: EditText
//    lateinit var btnLogin: Button
//    lateinit var btnRegister: Button
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        etEmail = findViewById(R.id.etEmail)
//        etPassword = findViewById(R.id.etPassword)
//        btnLogin = findViewById(R.id.btnLogin)
//        btnRegister = findViewById(R.id.btnRegister)

        binding.btnLogin.setOnClickListener{
            if(binding.etEmail.text.toString().isNullOrEmpty()){
                binding.etEmail.error="Enter Email"
            }
            else if(binding.etPassword.text.toString().isNullOrEmpty()){
                binding.etPassword.error="Enter password"
            }
            else if(binding.etPassword.text.toString().length<6 || binding.etPassword.text.toString().length>15){
                binding.etPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else{
                var intent = Intent(this@MainActivity ,After_login::class.java)
                intent.putExtra("email",binding.etEmail.text.toString())
                intent.putExtra("password",binding.etPassword.text.toString())
                startActivity(intent)
            }
        }

        binding.btnRegister.setOnClickListener{
            var intent = Intent(this@MainActivity,Register_page::class.java)
            startActivity(intent)
        }
    }
}