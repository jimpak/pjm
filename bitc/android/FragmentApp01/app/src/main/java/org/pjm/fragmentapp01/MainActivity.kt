package org.pjm.fragmentapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.pjm.fragmentapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmemtManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmemtManager.beginTransaction()
        val fragment = OneFragment()

        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

//        // View.OnClickListener를 사용하지 않을 때
//        binding.button1.setOnClickListener {
//            val fragmemtManager: FragmentManager = supportFragmentManager
//            val transaction: FragmentTransaction = fragmemtManager.beginTransaction()
//            val fragment = OneFragment()
//
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
//        binding.button2.setOnClickListener {
//            val fragmemtManager: FragmentManager = supportFragmentManager
//            val transaction: FragmentTransaction = fragmemtManager.beginTransaction()
//            val fragment = TwoFragment()
//
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
//        binding.button3.setOnClickListener {
//            val fragmemtManager: FragmentManager = supportFragmentManager
//            val transaction: FragmentTransaction = fragmemtManager.beginTransaction()
//            val fragment = ThreeFragment()
//
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
    }

    override fun onClick(v: View?) {
        val fragmemtManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmemtManager.beginTransaction()
        lateinit var fragment: Fragment

        when(v?.id) {
            R.id.button1 -> {
                fragment = OneFragment()
            }
            R.id.button2 -> {
                fragment = TwoFragment()
            }
            R.id.button3 -> {
                fragment = ThreeFragment()
            }
        }
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
