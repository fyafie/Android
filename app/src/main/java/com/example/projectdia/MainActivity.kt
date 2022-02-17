package com.example.projectdia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectdia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cvSatu.setOnClickListener{
            if (binding.etPin.text.toString() == "123"){
                val intent = Intent(this,Class.forName("com.example.projectdia.HalamanDua"))
                this.startActivity(intent)
            }else{
                Toast.makeText(this, "Pin Salah", Toast.LENGTH_SHORT).show()
            }

        }
    }
}