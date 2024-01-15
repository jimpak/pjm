package org.pjm.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.pjm.eventapp01.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityMain3Binding
    lateinit var btns: Array<Button?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val ids = arrayOf(R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9)

        binding.btnAdd.setOnClickListener(this)
        binding.btnMin.setOnClickListener(this)
        binding.btnMul.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val num1: Int = binding.edit1.text.toString().toInt()
        val num2: Int = binding.edit2.text.toString().toInt()
        when(v?.id) {
            R.id.btnAdd -> {
                binding.tvResult.setText("연산결과 : ${num1+num2}")
            }
            R.id.btnMin -> {
                binding.tvResult.setText("연산결과 : ${num1-num2}")
            }
            R.id.btnMul -> {
                binding.tvResult.setText("연산결과 : ${num1*num2}")
            }
            R.id.btnDiv -> {
                binding.tvResult.setText("연산결과 : ${num1/num2}")
            }
            else -> {
                if(binding.edit1.focusable)
            }
        }
    }
}