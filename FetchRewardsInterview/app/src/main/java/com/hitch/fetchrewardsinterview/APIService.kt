package com.hitch.fetchrewardsinterview

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("/hiring.json")
    suspend fun getHiringData(): List<Item>

}