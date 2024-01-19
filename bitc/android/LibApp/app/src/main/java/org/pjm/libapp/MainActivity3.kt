package org.pjm.libapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import org.pjm.libapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawer1,
            R.string.drawer_open,
            R.string.drawer_close
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

//        binding.navigationView1.setNavigationItemSelectedListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}

