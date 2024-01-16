package org.pjm.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.pjm.eventapp01.databinding.ActivityMain3Binding
import org.pjm.eventapp01.databinding.ActivityMain4Binding
import java.util.StringTokenizer

class MainActivity4 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain4Binding
    lateinit var btns: Array<Button>
    var str = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        btns = arrayOf(
            findViewById(R.id.btn0), findViewById(R.id.btn1),
            findViewById(R.id.btn2), findViewById(R.id.btn3),
            findViewById(R.id.btn4), findViewById(R.id.btn5),
            findViewById(R.id.btn6), findViewById(R.id.btn7),
            findViewById(R.id.btn8), findViewById(R.id.btn9),
            findViewById(R.id.btnPlus), findViewById(R.id.btnMinus),
            findViewById(R.id.btnMul), findViewById(R.id.btnDiv),
            findViewById(R.id.btnDot), findViewById(R.id.btnEqual)
        )

        for (b in btns) {
            b.setOnClickListener {

                val str1 = b.text.toString()

                if (str1.equals("=")) {
                    val dim = "+-*/"
                    val tk = StringTokenizer(str, dim, true)

                    val num1: Double = tk.nextToken().toDouble()
                    val op = tk.nextToken()
                    val num2: Double = tk.nextToken().toDouble()
                    var result: Double = 0.0

                    when (op) {
                        "+" -> {
                            result = num1 + num2
                            binding.tvResult.setText(result.toString())
                        }
                        "-" -> {
                            result = num1 - num2
                            binding.tvResult.setText(result.toString())
                        }
                        "*" -> {
                            result = num1 * num2
                            binding.tvResult.setText(result.toString())
                        }
                        "/" -> {
                            result = num1 / num2
                            binding.tvResult.setText(result.toString())
                        }
                    }
                    str = binding.tvResult.text.toString()

                } else {
                    str += b.text.toString()
                    binding.tvResult.setText(str)
                }
            }
        }
    }

    override fun onClick(v: View?) {

    }
}