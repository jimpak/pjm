package org.pjm.layoutapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.pjm.layoutapp01.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener(View.OnClickListener {
            val num1: Int = binding.ed1.text.toString().toInt()
            val num2: Int = binding.ed2.text.toString().toInt()
            binding.tvResult.setText((num1+num2).toString())
        })

        binding.btnMinus.setOnClickListener(View.OnClickListener {
            val num1: Int = binding.ed1.text.toString().toInt()
            val num2: Int = binding.ed2.text.toString().toInt()
            binding.tvResult.setText((num1-num2).toString())
        })

        binding.btnMul.setOnClickListener(View.OnClickListener {
            val num1: Int = binding.ed1.text.toString().toInt()
            val num2: Int = binding.ed2.text.toString().toInt()
            binding.tvResult.setText((num1*num2).toString())
        })

        binding.btnDiv.setOnClickListener(View.OnClickListener {
            val num1: Int = binding.ed1.text.toString().toInt()
            val num2: Int = binding.ed2.text.toString().toInt()
            binding.tvResult.setText((num1/num2).toString())
        })


    }
}