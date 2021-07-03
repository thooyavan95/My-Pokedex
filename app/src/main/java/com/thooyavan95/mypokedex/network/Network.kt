package com.thooyavan95.mypokedex.network

import com.thooyavan95.mypokedex.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance{

    private var retrofitInstance : Retrofit = Retrofit.Builder().apply {
        baseUrl(AppConstants.BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    var networkInstance : APIService = retrofitInstance.create(APIService::class.java)

}