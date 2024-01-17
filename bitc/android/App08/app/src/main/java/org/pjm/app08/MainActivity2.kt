package org.pjm.app08

import android.annotation.SuppressLint
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import org.pjm.app08.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("ServiceCast", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button6.setOnClickListener {
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            val rington = RingtoneManager.getRingtone(applicationContext, uri)
            rington.play()
        }

        binding.button7.setOnClickListener {
            val vibrator = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val manager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                manager.defaultVibrator

            } else {
                getSystemService(VIBRATOR_MANAGER_SERVICE) as Vibrator
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate (
                    VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(500)
            }
        }
    }
}