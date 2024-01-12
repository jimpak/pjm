package org.pjm.layoutapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = Layout4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btn001.setOnClickListener(View.OnClickListener {
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
        })

        binding.btn002.setOnClickListener(View.OnClickListener {
            binding.imageView5.visibility = View.INVISIBLE
            binding.imageView4.visibility = View.INVISIBLE
        })
    }
}