package com.gilbram.newsapi.Service


import com.gilbram.newsapi.Model.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuilder {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadLine::class.java)

}
//kesalahan spasi pada authorization//
interface TopHeadLine{
    @Headers("Authorization: 730b49091db74e40b16924b153a77032")
    @GET("/v2/top-headlines?country=id")
    fun fetchHeadlines (): Call<ResponseNews>
}