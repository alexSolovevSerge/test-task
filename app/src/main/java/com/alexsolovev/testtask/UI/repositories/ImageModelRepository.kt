package com.alexsolovev.testtask.UI.repositories


import android.media.Image
import com.alexsolovev.testtask.UI.api.RetrofitInstance
import com.alexsolovev.testtask.UI.model.ImageModel

class ImageModelRepository {
    suspend fun getImages(): List<ImageModel>{
        try {
            return RetrofitInstance.api.getArray()
        } catch (e: Exception) {
        } finally {
        }
        var a : MutableList<ImageModel> = mutableListOf()
        return a
    }
}

