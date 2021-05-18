package com.alexsolovev.testtask.UI.UI

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alexsolovev.testtask.R
import com.alexsolovev.testtask.UI.model.ImageModel
import com.alexsolovev.testtask.UI.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var mAdapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModel.init()
        mAdapter = RecycleAdapter(mViewModel.getImageModels().value)
        recycle_view_images.adapter = mAdapter
        recycle_view_images.layoutManager = GridLayoutManager(this,2)
        mViewModel.getImageModels().observe(this, Observer {
            mAdapter.notifyItemChanged(it.size-1)
        })
    }
}