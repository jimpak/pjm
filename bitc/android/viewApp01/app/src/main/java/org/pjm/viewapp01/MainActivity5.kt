package org.pjm.viewapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.pjm.viewapp01.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(View.OnClickListener {
            binding.tv.setText(binding.ed.text)
        })

    }
}