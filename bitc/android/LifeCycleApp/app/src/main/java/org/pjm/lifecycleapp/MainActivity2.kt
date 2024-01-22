package org.pjm.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import org.pjm.lifecycleapp.databinding.ActivityMain2Binding

//라이프사이클
class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCount.text = count.toString()

        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()

        binding.button2.setOnClickListener {
            finish()
        }

        binding.btnCount.setOnClickListener {
            count++
            binding.tvCount.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        val data = savedInstanceState?.getInt("count", 0)
        binding.tvCount.text = "${data}"
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