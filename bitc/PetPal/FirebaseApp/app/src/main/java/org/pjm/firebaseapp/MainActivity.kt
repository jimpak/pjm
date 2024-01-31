package org.pjm.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.pjm.firebaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        if (MyApplication.checkAuth()) {
            binding.logoutTextView.visibility = View.GONE
            binding.mainRecyclerView.visibility = View.VISIBLE
        } else {
            binding.logoutTextView.visibility = View.VISIBLE
            binding.mainRecyclerView.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_main_auth ->
                startActivity(Intent(this, AuthActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}