package org.pjm.newsapp

import android.app.Application
import org.pjm.newsapp.retrofit.INetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication : Application() {
    companion object {
        val QUERY = "travel"
        val API_KEY = "c372305e16a64629a85f89a190121204"
        val BASE_URL = "https://newsapi.org"
        val USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"

        var networkService: INetworkService
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        init {
            networkService = retrofit.create(INetworkService::class.java)
        }
    }
}