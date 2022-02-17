package com.example.projectdia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectdia.activity.HomeActivity
import com.example.projectdia.databinding.ActivityLoginBinding
import com.example.projectdia.ultils.PrefsKey
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            Prefs.putString(PrefsKey.USERNAME, username)
            Prefs.putString(PrefsKey.PASSWORD, username)
            Prefs.putBoolean(PrefsKey.IS_LOGIN, true)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}