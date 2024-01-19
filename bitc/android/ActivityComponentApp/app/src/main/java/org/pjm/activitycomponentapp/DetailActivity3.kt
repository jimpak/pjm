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

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) {
            val name = it.data?.getStringExtra("name")
            val age = it.data?.getIntExtra("age",0)
            val phone = it.data?.getStringExtra("phone")
            binding.tv1.setText(name)
            binding.tv2.setText(age.toString())
            binding.tv3.setText(phone)
        }

        binding.btnClose.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}