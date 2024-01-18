package org.pjm.viewpageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.pjm.viewpageapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() { // Fragment 를 활용한 view_pager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager3.adapter = MyFragmentAdapter(this)
    }
}

class MyFragmentAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments:List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
