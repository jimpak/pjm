package org.pjm.viewapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val chk: CheckBox = findViewById(R.id.cb)
        val rg1: RadioGroup = findViewById(R.id.rg1)
        val rb1: RadioButton = findViewById(R.id.rb1)
        val rb2: RadioButton = findViewById(R.id.rb2)
        val iv1: ImageView = findViewById(R.id.iv1)
        val iv2: ImageView = findViewById(R.id.iv2)

        chk.setOnClickListener(View.OnClickListener {
            if(chk.isChecked) {
                rg1.visibility = View.VISIBLE
            } else {
                rg1.visibility = View.INVISIBLE
                iv1.visibility = View.GONE
                iv2.visibility = View.GONE
            }
        })

        rb1.setOnClickListener(View.OnClickListener {
            iv2.visibility = View.GONE
            iv1.visibility = View.VISIBLE
        })

        rb2.setOnClickListener(View.OnClickListener {
            iv1.visibility = View.GONE
            iv2.visibility = View.VISIBLE
        })
    }
}