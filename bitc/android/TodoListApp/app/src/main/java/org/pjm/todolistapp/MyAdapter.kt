package org.pjm.todolistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pjm.todolistapp.databinding.ItemBinding


class MyViewholder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)
class MyAdapter(val datas:MutableList<DayJob>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewholder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        // 삼항연산자. datas가 true이면 그대로 진행. null일 경우 0 리턴.
        return datas?.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewholder).binding
        // ? : null 허용, !! : not null
        binding.textView.text = datas!![position].toString()
    }

}