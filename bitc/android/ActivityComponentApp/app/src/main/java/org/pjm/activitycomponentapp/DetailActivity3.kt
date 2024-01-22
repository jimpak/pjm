package org.pjm.activitycomponentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.pjm.activitycomponentapp.databinding.ActivityDetail3Binding

class DetailActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val phone = intent.getStringExtra("phone")

        binding.tv1.setText(name)
        binding.tv2.setText(age)
        binding.tv3.setText(phone)


        binding.btnClose.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}