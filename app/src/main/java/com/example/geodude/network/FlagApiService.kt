package com.example.geodude.network

import retrofit2.http.GET

interface FlagApiService {
	@GET("en/codes.json")
	suspend fun getFlagCodes(): Map<String, String>
}