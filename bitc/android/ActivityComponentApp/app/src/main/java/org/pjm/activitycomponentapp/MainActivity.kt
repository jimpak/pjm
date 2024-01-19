package org.pjm.activitycomponentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import org.pjm.activitycomponentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher:ActivityResultLauncher<Intent> = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) {
            val resultData = it.data?.getIntExtra("result", 0)
            binding.tvResult.text = "result:$resultData"
        }

        binding.button.setOnClickListener {
            val intent: Intent = Intent(this, DetailActivity::class.java)
            val num1 = binding.edit1.text.toString().toInt()
            val num2 = binding.edit2.text.toString().toInt()
            intent.putExtra("num1", num1)
            intent.putExtra("num2", num2)
            requestLauncher.launch(intent)
        }

        // Detail Activity로 값을 전달하지만 값을 다시 전달받진 못하고 있음.
//        binding.button.setOnClickListener {
//            val intent: Intent = Intent(applicationContext, DetailActivity::class.java)
//            intent.putExtra("name", "홍길동")
//            intent.putExtra("age", 20)
//            startActivity(intent)
//        }
    }
}