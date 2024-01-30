package org.pjm.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import org.pjm.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDraw.setOnClickListener {
            Glide.with(this)
                .load(R.drawable.businessman)
                .override(500, 500)
                .into(binding.imageView)
        }
        binding.btnUrl.setOnClickListener {
            val url = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMTFfMjc2%2FMDAxNjk5NzE0Mzg5NzM5.MJGGkFkr9VZO2uQhvvp1KgbCS6lyGfzwCUg3Uoua5egg.KDjCXQ72Rdzq9hbwYEr32bMr60kWfGfFjGoRLDgAqy8g.JPEG.rina_1020%2F%25C8%25AA%25C4%25AB%25C0%25CC%25B5%25B5_%25BA%25F1%25BF%25A1%25C0%25CC_%25285%2529.jpg&type=sc960_832"
            Glide.with(this)
                .load(url)
                .override(500, 500)
                .into(binding.imageView)
        }
    }
}