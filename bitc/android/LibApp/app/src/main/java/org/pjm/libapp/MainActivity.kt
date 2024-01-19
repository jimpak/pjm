package org.pjm.libapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import org.pjm.libapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 툴바
        setSupportActionBar(binding.toolbar1)
    }

    // 메뉴
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test, menu)
        return super.onCreateOptionsMenu(menu)
    }
}