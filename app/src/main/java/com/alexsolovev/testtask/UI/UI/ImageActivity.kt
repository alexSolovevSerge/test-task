package com.alexsolovev.testtask.UI.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import com.alexsolovev.testtask.R
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val url = intent.getStringExtra("url")?:""
        try {
            image_view_selected.load(url)
        } catch (e: Exception) {
        }
    }
}