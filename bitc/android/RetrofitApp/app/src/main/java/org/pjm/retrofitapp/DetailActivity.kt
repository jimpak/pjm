package org.pjm.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.pjm.retrofitapp.databinding.ActivityDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getLongExtra("id", 0)
        val username = intent.getStringExtra("username")
        val networkService = (applicationContext as MyApplication).networkService
        val userModelCall = networkService.doGetUserId(id)

//        val userModelCall = networkService.doGetUsername(username)
        userModelCall.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val userModel = response.body()
                binding.tvDetail.text = """
                    id:${userModel?.id}
                    username:${userModel?.username}
                    password:${userModel?.password}
                    role:${userModel?.roles}
                """.trimIndent()
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("aaaa", "fail")
                call.cancel()
            }

        })
    }
}