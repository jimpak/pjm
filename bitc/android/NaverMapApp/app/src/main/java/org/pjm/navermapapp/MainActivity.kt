package org.pjm.navermapapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.navermapapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val intent = Intent(this, Map1Activity::class.java)
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(this, Map2Activity::class.java)
            startActivity(intent)
        }

        binding.btn3.setOnClickListener {
            val intent = Intent(this, Map3Activity::class.java)
            startActivity(intent)
        }
    }
}