package com.example.paginghomework.network

import com.example.paginghomework.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitClient {

    private const val BASE_URL = "https://reqres.in/api/"

    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val getUsersInfo: UserInfo by lazy {
        retrofitBuilder.create(UserInfo::class.java)
    }

    interface UserInfo {
        @GET("users")
        suspend fun getUsers(@Query("page") page: Int): Response<User>
    }
}
