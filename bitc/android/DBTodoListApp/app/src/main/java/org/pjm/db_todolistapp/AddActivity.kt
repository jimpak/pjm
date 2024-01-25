package org.pjm.db_todolistapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.pjm.db_todolistapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_save_add -> {
                val intent = intent
                intent.putExtra("name", binding.addEdit.text.toString())
                intent.putExtra("phone", binding.addEdit2.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
                true
            }
            else -> true
        }
        return super.onOptionsItemSelected(item)
    }
}