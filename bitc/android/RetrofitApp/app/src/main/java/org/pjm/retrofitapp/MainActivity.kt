package org.pjm.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.pjm.retrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Volley
        val queue = Volley.newRequestQueue(this)
        binding.button.setOnClickListener {
            val request = StringRequest(
                Request.Method.GET,
                "http://10.100.105.152:8082/api/home",
                Response.Listener<String> {
                    binding.textView.text = "$it"
                },
                Response.ErrorListener { error -> binding.textView.text = "$error" }
            )
            queue.add(request)
        }
    }
}