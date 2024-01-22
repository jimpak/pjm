package org.pjm.lifecycleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import org.pjm.lifecycleapp.databinding.ActivityMainBinding

//라이프사이클
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        Toast.makeText(this, "OnCreate()", Toast.LENGTH_SHORT).show()

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnShow.setOnClickListener {
            binding.edit1.requestFocus()
            manager.showSoftInput(binding.edit1, InputMethodManager.SHOW_IMPLICIT)
        }

        binding.btnHide.setOnClickListener {
            manager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }
}