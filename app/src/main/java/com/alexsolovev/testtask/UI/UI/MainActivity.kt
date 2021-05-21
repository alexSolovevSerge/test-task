package com.alexsolovev.testtask.UI.UI

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
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

class MainActivity : AppCompatActivity(), RecycleAdapter.OnItemClickListener {

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
        if (isTablet(this)) {
            recycle_view_images.layoutManager = GridLayoutManager(this, 3)
        } else {
            recycle_view_images.layoutManager = GridLayoutManager(this, 2)
        }
        mViewModel.mImageModels.observe(this, Observer { responce ->
            mAdapter = RecycleAdapter(mViewModel.mImageModels.value!!, this)
            recycle_view_images.adapter = mAdapter
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ImageActivity::class.java).apply {
            putExtra("url", mAdapter.getItem(position).download_url)
        }
        startActivity(intent)
    }

    fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }
}