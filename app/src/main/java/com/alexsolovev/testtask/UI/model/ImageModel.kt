package com.alexsolovev.testtask.UI.model

import android.graphics.Bitmap

data class ImageModel(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
    )