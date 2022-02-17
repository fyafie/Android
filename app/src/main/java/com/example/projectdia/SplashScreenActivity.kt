package com.example.projectdia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.projectdia.activity.HomeActivity
import com.example.projectdia.databinding.ActivitySplashScreenBinding
import com.example.projectdia.ultils.PrefsKey
import com.pixplicity.easyprefs.library.Prefs

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            val isLogin = Prefs.getBoolean(PrefsKey.IS_LOGIN, false)
            if (isLogin) {
                val intent = Intent(this, HomeActivity::class.java)
                this.startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                this.startActivity(intent)
            }
        },3000)
    }
}