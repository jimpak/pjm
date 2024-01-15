package org.pjm.resapp001

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import org.pjm.resapp001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView.text = getString(R.string.txt_data)
        binding.textView.setTextColor(ResourcesCompat.getColor(resources, R.color.blue, null))
        binding.textView.textSize = resources.getDimension(R.dimen.txt_size1)
    }
}