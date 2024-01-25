package org.pjm.databaseapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.databaseapp.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewGet.setOnClickListener {
            val newShardPref = getSharedPreferences("my_pref", Context.MODE_PRIVATE)
            val data3 = newShardPref.getString("data3", "aaaa")
            val data4 = newShardPref.getInt("data4", 0)
            binding.tvNew.text = "$data3, $data4"
        }
    }
}