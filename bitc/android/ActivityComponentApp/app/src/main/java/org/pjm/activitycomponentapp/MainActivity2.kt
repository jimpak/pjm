package org.pjm.activitycomponentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.pjm.activitycomponentapp.databinding.ActivityMain2Binding
import org.pjm.activitycomponentapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) {
            val name = it.data?.getStringExtra("name")
            val age = it.data?.getIntExtra("age",0)
            val phone = it.data?.getStringExtra("phone")

            binding.tvResult.text = "name:$name, age:$age, phone:$phone"
        }


        binding.inbtn.setOnClickListener {
            val intent2: Intent = Intent(applicationContext, DetailActivity2::class.java)
            requestLauncher.launch(intent2)
        }

        binding.outbtn.setOnClickListener {
            val intent3: Intent = Intent(applicationContext, DetailActivity3::class.java)
            requestLauncher.launch(intent3)
        }

    }
}