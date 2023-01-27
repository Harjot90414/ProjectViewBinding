package com.harjot.projectviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class After_Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_register)
        var email = intent?.getStringExtra("email")?:""
        var password = intent?.getStringExtra("password")?:""
        System.out.println("email $email password $password")
    }
}