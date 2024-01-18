package org.pjm.viewpageapp

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pjm.viewpageapp.databinding.ActivityMain2Binding
import org.pjm.viewpageapp.databinding.ActivityMainBinding
import org.pjm.viewpageapp.databinding.ItemBinding
import org.pjm.viewpageapp.databinding.ItemLayoutBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding // 이미지 적용 view_pager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = arrayOf("써니", "완득이", "괴물", "라디오스타", "비열한거리", "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "백투더퓨처")
        val rids = arrayOf(R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10)
        val datas = mutableListOf<Movie>()
        for(i in 0 .. 9) {
            datas.add(Movie(names[i], rids[i]))
        }

        binding.viewPager2.adapter = MyPagerAdapter(datas)
    }

    class MyPagerViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    class MyPagerAdapter(val datas:MutableList<Movie>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return MyPagerViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding =(holder as MyPagerViewHolder).binding

            binding.title.setText(datas[position].title)
            binding.poster.setImageResource(datas[position].rid)
        }

    }

}