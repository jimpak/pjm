package org.pjm.activitycomponentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.activitycomponentapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val num1 = intent.getIntExtra("num1", 0)
        val num2 = intent.getIntExtra("num2", 0)

        binding.textView.setText("num1:$num1, num2:$num2")

        binding.btnBack.setOnClickListener {
            val sum = num1 + num2
            intent.putExtra("result", sum)
            setResult(RESULT_OK, intent)
            finish()
        }

//        // MainActivity에서 전달한 값 가져오기.
//        val name = intent.getStringExtra("name")
//        val age = intent.getIntExtra("age", 0)
//
//        binding.textView.setText("name:$name, age:$age")
    }
}