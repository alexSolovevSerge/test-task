package com.alexsolovev.testtask.UI.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexsolovev.testtask.UI.model.ImageModel
import com.alexsolovev.testtask.UI.repositories.ImageModelRepository

class MainActivityViewModel : ViewModel() {
    private lateinit var mImageModels: MutableLiveData<List<ImageModel>>
    private lateinit var imageModeRepo: ImageModelRepository

    fun getImageModels(): LiveData<List<ImageModel>> {
        return mImageModels
    }

    fun init() {
        imageModeRepo = ImageModelRepository
        mImageModels = ImageModelRepository.getResult()
    }
}