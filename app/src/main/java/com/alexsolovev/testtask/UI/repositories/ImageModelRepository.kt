package com.alexsolovev.testtask.UI.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alexsolovev.testtask.UI.api.RetrofitInstance
import com.alexsolovev.testtask.UI.model.ImageModel
import kotlinx.coroutines.*
import org.json.JSONArray
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

class ImageModelRepository {

    suspend fun getImages(): List<ImageModel>{
        return RetrofitInstance.api.getArray()
    }

}

