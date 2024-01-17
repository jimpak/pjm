package org.pjm.app09

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import org.pjm.app09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        val menuItem = menu?.findItem(R.id.menu3)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.tv1.setText(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.tv1.setText(newText)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                binding.tv1.setTextColor(Color.RED)
                true
            }

            R.id.menu2 -> {
                binding.tv1.setTextColor(Color.GREEN)
                true
            }

            R.id.menu3 -> {
                binding.tv1.setTextColor(Color.BLUE)
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // resources로 menu를 구현하는 방법.
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu1, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.menu1 -> {
//                binding.tv1.setTextColor(Color.RED)
//                true
//            }
//            R.id.menu2 -> {
//                binding.tv1.setTextColor(Color.GREEN)
//                true
//            }
//            R.id.menu3 -> {
//                binding.tv1.setTextColor(Color.BLUE)
//                true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


    // 이벤트 함수를 활용하여 메뉴 생성
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuItem1: MenuItem? = menu?.add(0, 0, 0, "menu1")
//        val menuItem2: MenuItem? = menu?.add(0, 1, 0, "menu2")
//        val menuItem3: MenuItem? = menu?.add(0, 2, 0, "menu3")
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            0 -> {
//                binding.tv1.setTextColor(Color.RED)
//                true
//            }
//            1 -> {
//                binding.tv1.setTextColor(Color.GREEN)
//                true
//            }
//            2 -> {
//                binding.tv1.setTextColor(Color.BLUE)
//                true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}