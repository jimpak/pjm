package org.pjm.app09

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.pjm.app09.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.button1)
        registerForContextMenu(binding.button2)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id) {
            R.id.button1 -> {
                menu?.setHeaderTitle("button1 menu")
                menuInflater.inflate(R.menu.button_menu1, menu)
            }
            R.id.button2 -> {
                menu?.setHeaderTitle("button2 menu")
                menuInflater.inflate(R.menu.button_menu2, menu)
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.s20 -> {
                binding.button1.setTextSize(20.0f)
                true
            }
            R.id.s30 -> {
                binding.button1.setTextSize(30.0f)
                true
            }
            R.id.red -> {
                binding.button2.setTextColor(Color.RED)
                true
            }
            R.id.green -> {
                binding.button2.setTextColor(Color.GREEN)
                true
            }
            R.id.blue -> {
                binding.button2.setTextColor(Color.BLUE)
                true
            }
        }

        return super.onContextItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.size20 -> {
                binding.tv.setTextSize(20.0f)
                true
            }
            R.id.size30 -> {
                binding.tv.setTextSize(30.0f)
                true
            }
            R.id.size40 -> {
                binding.tv.setTextSize(40.0f)
                true
            }
            R.id.red -> {
                binding.tv.setTextColor(Color.RED)
                true
            }
            R.id.green -> {
                binding.tv.setTextColor(Color.GREEN)
                true
            }
            R.id.blue -> {
                binding.tv.setTextColor(Color.BLUE)
                true
            }

        }

        return super.onOptionsItemSelected(item)
    }
}