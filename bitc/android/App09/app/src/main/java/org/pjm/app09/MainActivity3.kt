package org.pjm.app09

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import org.pjm.app09.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.imageView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id) {
            R.id.imageView -> {
                menu?.setHeaderTitle("imageView menu")
                menuInflater.inflate(R.menu.image_menu2, menu)
            }
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.a15 -> {
                binding.imageView.rotation += 15.0f
                true
            }
            R.id.a45 -> {
                binding.imageView.rotation += 45.0f
                true
            }
            R.id.a90 -> {
                binding.imageView.rotation += 90.0f
                true
            }
            R.id.a0 -> {
                binding.imageView.rotation = 0.0f
                true
            }
        }

        return super.onContextItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.image_menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val layoutParams = binding.imageView.layoutParams as ViewGroup.LayoutParams

        when(item.itemId) {
            R.id.up -> {
                layoutParams.width *= 2
                layoutParams.height *= 2
                binding.imageView.layoutParams = layoutParams
                true
            }
            R.id.down -> {
                layoutParams.width /= 2
                layoutParams.height /= 2
                binding.imageView.layoutParams = layoutParams
                true
            }

        }

        return super.onOptionsItemSelected(item)
    }
}