package com.harjot.projectviewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.harjot.projectviewbinding.databinding.ActivityMainBinding
import com.harjot.projectviewbinding.databinding.ActivityRegisterPageBinding

class Register_page : AppCompatActivity() {
//    lateinit var etName: EditText
//    lateinit var etUsername: EditText
//    lateinit var etEmail: EditText
//    lateinit var etPassword: EditText
//    lateinit var etConfPassword: EditText
//    lateinit var Confirm: Button
    lateinit var binding: ActivityRegisterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            if (binding.etName.text.toString().isNullOrEmpty()) {
                binding.etName.error ="Enter Name"
            }
            else if (binding.etUsername.text.toString().isNullOrEmpty()) {
                binding.etUsername.error ="Enter Username"
            }
            else if(binding.rbMale.text.toString().isNullOrEmpty()){
                Toast.makeText(this,resources.getString(R.string.select_gender),Toast.LENGTH_SHORT).show()
            }
            else if(binding.rbFemale.text.toString().isNullOrEmpty()){
                Toast.makeText(this,resources.getString(R.string.select_gender),Toast.LENGTH_SHORT).show()
            }
            else if (binding.etRegEmail.text.toString().isNullOrEmpty()) {
                binding.etRegEmail.error ="Enter Email"
            }
            else if (binding.etRegPassword.text.toString().isNullOrEmpty()) {
                binding.etRegPassword.error ="Enter Password"
            }
            else if(binding.etConfPassword.text.toString().isNullOrEmpty()){
                binding.etConfPassword.error = "Enter Confirm Password"
            }
            else if(binding.etRegPassword.text.toString().length<6 || binding.etRegPassword.text.toString().length>15){
                binding.etRegPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else if(binding.etConfPassword.text.toString().length<6 || binding.etConfPassword.text.toString().length>15){
                binding.etConfPassword.error="Password must not be less than 6 characters and should not exceed 15 characters"
            }
            else if(binding.etRegPassword.text.toString() != binding.etConfPassword.text.toString()){

                binding.etConfPassword.error = "Password doesn't match"
            }
            else{
                var intent = Intent(this@Register_page,After_Register::class.java)
                intent.putExtra("email",binding.etRegEmail.text.toString())
                intent.putExtra("password",binding.etRegPassword.text.toString())
                startActivity(intent)
            }
        }
    }
}