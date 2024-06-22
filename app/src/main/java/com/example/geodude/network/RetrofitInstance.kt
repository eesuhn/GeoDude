package com.example.geodude.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
	private const val BASE_URL = "https://flagcdn.com/"

	val api: FlagApiService by lazy {
		Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(FlagApiService::class.java)
	}
}