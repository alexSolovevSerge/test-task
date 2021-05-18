package com.alexsolovev.testtask.UI.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alexsolovev.testtask.UI.model.ImageModel
import kotlinx.coroutines.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object ImageModelRepository {
    private var imageModelList: MutableList<ImageModel> = mutableListOf()
    suspend fun getImage(): MutableLiveData<List<ImageModel>> {
        imageModelList.removeAll { it != null }
        var imageModels: MutableLiveData<List<ImageModel>> = MutableLiveData()
        val url = URL("http://dev-tasks.alef.im/task-m-001/list.php")
        val urlConnection = url.openConnection() as HttpURLConnection
        var reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
        var builder: StringBuilder = StringBuilder()
        var line: String?
        line = reader.readLine()
        while (line != null) {
            builder.append(line)
            line = reader.readLine()
        }
        val result = JSONArray(builder.toString())
        for (i in 0..result.length() - 1) {
            imageModelList.add(ImageModel(result[i].toString()))
        }
        imageModelList.forEach { Log.i("TAG", it.imageURL ?: "") }
        imageModels.value = imageModelList
        return imageModels
    }

    fun getResult(): MutableLiveData<List<ImageModel>>{
        var result  = MutableLiveData<List<ImageModel>>()
        runBlocking {
            val models = async { getImage() }
            runBlocking {
                result = models.await()
            }
        }
        return result
    }
}

