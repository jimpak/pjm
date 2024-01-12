package org.pjm.viewapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.pjm.viewapp01.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener(View.OnClickListener {
            val email: String = binding.edEmail.text.toString()
            val pass: String = binding.edPass.text.toString()

            binding.tvResult1.setText("email:$email, password:$pass")

        })
    }
}