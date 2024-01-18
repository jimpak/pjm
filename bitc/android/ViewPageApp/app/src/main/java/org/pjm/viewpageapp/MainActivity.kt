package org.pjm.viewpageapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pjm.viewpageapp.databinding.ActivityMainBinding
import org.pjm.viewpageapp.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding // view_pager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for(i in 1 .. 10) {
            datas.add("item data $i")
        }

        binding.viewPager1.adapter = MyPagerAdapter(datas)
    }
}

class MyPagerViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas:MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyPagerViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding =(holder as MyPagerViewHolder).binding
        binding.textView.text = datas[position]
        when(position % 3) {
            0 -> binding.textView.setBackgroundColor(Color.RED)
            1 -> binding.textView.setBackgroundColor(Color.GREEN)
            2 -> binding.textView.setBackgroundColor(Color.BLUE)
        }
    }

}