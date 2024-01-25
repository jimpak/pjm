package org.pjm.databaseapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pjm.databaseapp.databinding.ActivityMain3Binding
import java.io.IOException
import java.nio.charset.Charset

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWrite.setOnClickListener {
            var outFs = openFileOutput("test.txt", Context.MODE_PRIVATE)
            var str = binding.edit.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            binding.tvFileResult.text = "생성완료"
        }

        binding.btnRead.setOnClickListener {
            try {
                var inFs = openFileInput("test.txt")
                var txt = ByteArray(inFs.available())
                inFs.read(txt)
                inFs.close()
                var str = txt.toString(Charset.defaultCharset())
                binding.tvFileResult.text = str
            } catch (e:IOException) {
                binding.tvFileResult.text = "파일없음"
//                e.printStackTrace()
            }
        }
    }
}