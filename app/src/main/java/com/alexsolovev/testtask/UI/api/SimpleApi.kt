package com.alexsolovev.testtask.UI.api

import com.alexsolovev.testtask.UI.model.ImageModel
import org.json.JSONObject
import retrofit2.http.GET

interface SimpleApi {
    @GET("v2/list")
    suspend fun getArray(): List<ImageModel>

}