package org.pjm.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.pjm.lifecycleapp.databinding.ActivityMain3Binding
import kotlin.system.measureNanoTime

// 코루틴
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            val channel = Channel<Int>()
            var sum = 0L

            val scope = CoroutineScope(Dispatchers.Default + Job())
            scope.launch {
                var time = measureNanoTime {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                channel.send(sum.toInt())
            }
            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.textView.text = "$sum"
                }
            }
        }
    }
}