package org.pjm.libapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import org.pjm.libapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBindingUtil을 사용하여 레이아웃 인플레이팅 및 바인딩 클래스 생성
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 초기 프래그먼트 설정
        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text) {
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}