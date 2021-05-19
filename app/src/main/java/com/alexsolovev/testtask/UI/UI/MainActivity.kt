package com.alexsolovev.testtask.UI.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alexsolovev.testtask.R
import com.alexsolovev.testtask.UI.repositories.ImageModelRepository
import com.alexsolovev.testtask.UI.viewmodels.MainActivityViewModel
import com.alexsolovev.testtask.UI.viewmodels.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var mAdapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = ImageModelRepository()
        val mainActivityViewModelFactory = MainActivityViewModelFactory(repository)
        mViewModel = ViewModelProvider(
            this,
            mainActivityViewModelFactory
        ).get(MainActivityViewModel::class.java)
        mViewModel.getImages()
        recycle_view_images.layoutManager = GridLayoutManager(this, 2)
        mViewModel.mImageModels.observe(this, Observer { responce ->
            mAdapter = RecycleAdapter(mViewModel.mImageModels.value!!)
            recycle_view_images.adapter = mAdapter
            mAdapter.notifyDataSetChanged()
        })
    }
}