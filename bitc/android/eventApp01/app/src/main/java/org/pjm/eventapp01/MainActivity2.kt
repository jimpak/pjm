package org.pjm.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import org.pjm.eventapp01.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var initTime = 0L // 시작 시간
    var pauseTime = 0L // 정지했을때 시간

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            binding.chronometer1.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer1.start()
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
        }

        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer1.base - SystemClock.elapsedRealtime()
            binding.chronometer1.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
        }

        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer1.base = SystemClock.elapsedRealtime()
            binding.chronometer1.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }
    }
}