package org.pjm.databaseapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.databaseapp.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val sharedPref = getSharedPreferences("my_pref", Context.MODE_PRIVATE)
        
        // Preferences에 값을 넣는 법
        binding.btnPut.setOnClickListener {
            pref.edit().run {
                putString("data1", "hell1")
                putInt("data2", 10)
                commit()
            }
            sharedPref.edit().run {
                putString("data3", "world")
                putInt("data4", 20)
                commit()
            }
        }

        binding.btnGet.setOnClickListener {
            val data1 = pref.getString("data1", "aaaa")
            val data2 = pref.getInt("data2", 0)
            val data3 = sharedPref.getString("data3", "aaaa")
            val data4 = sharedPref.getInt("data4", 0)
            binding.tvPref.text = "$data1, $data2, $data3, $data4"
        }

        binding.btnNew.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

    }
}