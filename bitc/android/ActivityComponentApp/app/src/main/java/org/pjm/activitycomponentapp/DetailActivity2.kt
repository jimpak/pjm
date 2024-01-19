package org.pjm.activitycomponentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.pjm.activitycomponentapp.databinding.ActivityDetail2Binding
import org.pjm.activitycomponentapp.databinding.ActivityDetailBinding

class DetailActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent: Intent = Intent(this, DetailActivity::class.java)
            val name = binding.editname.text.toString()
            val age = binding.editage.text.toString().toInt()
            val phone = binding.editphone.text.toString()
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("phone", phone)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}