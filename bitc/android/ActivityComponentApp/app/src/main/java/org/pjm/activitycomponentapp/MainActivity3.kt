package org.pjm.activitycomponentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.activitycomponentapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        binding.btnMap.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.77,127.41"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }


    }
}