package org.pjm.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import org.pjm.eventapp01.databinding.ActivityMain3Binding
import java.util.StringTokenizer

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityMain3Binding
    lateinit var btns: Array<Button>
    var str1=""
    var str2=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(this)
        binding.btnMin.setOnClickListener(this)
        binding.btnMul.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)

        btns = arrayOf(findViewById(R.id.btn0), findViewById(R.id.btn1),
            findViewById(R.id.btn2), findViewById(R.id.btn3),
            findViewById(R.id.btn4), findViewById(R.id.btn5),
            findViewById(R.id.btn6), findViewById(R.id.btn7),
            findViewById(R.id.btn8), findViewById(R.id.btn9))

        for(b in btns) {
            b.setOnClickListener {
                if(binding.edit1.isFocused) {
                    str1 += b.text.toString()
                    binding.edit1.setText(str1)
                } else if (binding.edit2.isFocused) {
                    str2 += b.text.toString()
                    binding.edit2.setText(str2)
                }
            }
        }

//        binding.btn0.setOnClickListener(this)
//        binding.btn1.setOnClickListener(this)
//        binding.btn2.setOnClickListener(this)
//        binding.btn3.setOnClickListener(this)
//        binding.btn4.setOnClickListener(this)
//        binding.btn5.setOnClickListener(this)
//        binding.btn6.setOnClickListener(this)
//        binding.btn7.setOnClickListener(this)
//        binding.btn8.setOnClickListener(this)
//        binding.btn9.setOnClickListener(this)

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
        }
        str1=""
        str2=""
        binding.edit1.setText(str1)
        binding.edit2.setText(str2)
    }

    fun func1() {
        val str1 = "10+20"
        val dim = "+-*/"
        val str = StringTokenizer(str1, dim, true)
        val num1:Int = str.nextToken().toInt()
        val op = str.nextToken()
        val num2:Int = str.nextToken().toInt()
    }
}