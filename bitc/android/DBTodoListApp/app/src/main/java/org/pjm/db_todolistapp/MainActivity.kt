package org.pjm.db_todolistapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.pjm.db_todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var datas: MutableList<User> = mutableListOf()
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add
        val requestLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val name = it.data?.getStringExtra("name")
                    val phone = it.data?.getStringExtra("phone")
                    name?.let {
                        datas.add(User(it, phone ?: ""))
                        adapter.notifyDataSetChanged()
                    }
                }
            }

        val detailLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { }

        binding.mainFab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        var layoutManager = LinearLayoutManager(this)
        binding.recyclerView1.layoutManager = layoutManager
        adapter = MyAdapter(datas) { user ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", user.name)
            intent.putExtra("content", user.phone)
            detailLauncher.launch(intent)
        }
        binding.recyclerView1.adapter = adapter
        binding.recyclerView1.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }
}
