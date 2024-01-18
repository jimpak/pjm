package org.pjm.recyclerviewapp01

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.pjm.recyclerviewapp01.databinding.ActivityMain2Binding
import org.pjm.recyclerviewapp01.databinding.ItemLayoutBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = arrayOf("홍길동", "권유미", "최수열", "강소희", "김도형")
        val phones = arrayOf("010-1111-1231","010-2222-1235","010-3333-1232","010-4444-1239","010-5555-1235",)
        val rids = arrayOf(R.drawable.img, R.drawable.person, R.drawable.businessman, R.drawable.woman, R.drawable.man)
        val data = mutableListOf<Person>()
        for(i in 0 .. 4) {
            data.add(Person(names[i], phones[i], rids[i]))
        }

        binding.recyclerview2.layoutManager = LinearLayoutManager(this)
        binding.recyclerview2.adapter = MyAdapter2(data, binding)
//        binding.recyclerview2.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.recyclerview2.addItemDecoration(MyDecoration(this))

    }
}

class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.stadium),
            0f,
            0f,
            null
        )
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1

        if (index % 3 == 0) {
            outRect.set(10, 10, 10, 30)
        } else {
            outRect.set(10, 10, 10, 10)
        }
        view.setBackgroundColor(Color.LTGRAY)
        ViewCompat.setElevation(view, 30.0f)
    }
}

class MyViewHolder2(val binding:ItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter2(val data: MutableList<Person>, val abinding:ActivityMain2Binding): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder2(ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder2).binding
//        if(position%2 == 0) {
//            binding.imageView.setImageResource(R.drawable.img)
//        } else {
//            binding.imageView.setImageResource(R.drawable.person)
//        }
        binding.tvName.text = data[position].name
        binding.tvPhone.text = data[position].phone
        binding.imageView.setImageResource(data[position].rid)

        binding.root.setOnClickListener {
            abinding.tvResult.text = "name:${data[position].name}, phone:${data[position].phone}"
        }
    }

}