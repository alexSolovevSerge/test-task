package com.alexsolovev.testtask.UI.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexsolovev.testtask.UI.repositories.ImageModelRepository

class MainActivityViewModelFactory(
    private val repository: ImageModelRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }

}