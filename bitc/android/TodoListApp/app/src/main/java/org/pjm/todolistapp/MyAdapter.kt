package org.pjm.todolistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pjm.todolistapp.databinding.ItemBinding


class MyViewholder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)
class MyAdapter(val datas: MutableList<DayJob>?, val itemClick: (DayJob) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewholder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewholder).binding
        val data = datas?.get(position)
        data?.let {
            binding.textView.text = it.title
//            binding.textView2.text = it.content

            // 아이템을 클릭했을 때 상세 페이지로 이동
            binding.root.setOnClickListener { _ ->
                itemClick.invoke(it)
            }
        }
    }
}
