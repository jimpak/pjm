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

        var name = ""
        var age = ""
        var phone = ""

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val nameResult = data?.getStringExtra("name")
                val ageResult = data?.getIntExtra("age", 0)
                val phoneResult = data?.getStringExtra("phone")

                name = "이름 : $nameResult"
                age = "나이 : $ageResult"
                phone = "연락처 : $phoneResult"

                binding.tvResult.text = "$name, $age, $phone"
            }
        }

        binding.inbtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, DetailActivity2::class.java)
            requestLauncher.launch(intent)
        }

        binding.outbtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, DetailActivity3::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age.toString())
            intent.putExtra("phone", phone)
            requestLauncher.launch(intent)
        }
    }
}
