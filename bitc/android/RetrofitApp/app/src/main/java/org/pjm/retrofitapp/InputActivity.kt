package org.pjm.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.pjm.retrofitapp.databinding.ActivityInputBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            var userModel = UserModel(id=0,
                username = binding.editName.text.toString(),
                password = binding.editPass.text.toString(),
                roles = binding.editRole.text.toString())
            val networkService = (applicationContext as MyApplication).networkService
            val userInsertCall = networkService.insert(userModel)
            userInsertCall.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("aaaa", "success")
                    Log.d("aaaa", response.body().toString())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("aaaa", "fail")
                    call.cancel()
                }
            })
            finish()
        }
    }
}