package org.pjm.retrofitapp

import android.app.Application
import com.bumptech.glide.Glide.init
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {
    var networkService: INetworkService
    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://10.100.105.152:8082/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    init {
        networkService = retrofit.create(INetworkService::class.java)

    }
}