package com.alexsolovev.testtask.UI.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexsolovev.testtask.UI.model.ImageModel
import com.alexsolovev.testtask.UI.repositories.ImageModelRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: ImageModelRepository) : ViewModel() {

    var mImageModels: MutableLiveData<List<ImageModel>> = MutableLiveData()

    fun getImages(){
        viewModelScope.launch {
            val retult = repository.getImages()
            mImageModels.value = retult
            Log.i("TAG","TAG")
        }
    }
}