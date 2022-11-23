package com.app.jetpackhiltdemo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.app.jetpackhiltdemo.R
import com.app.jetpackhiltdemo.model.RepositoriesModel
import com.app.jetpackhiltdemo.network.ResultData
import com.app.jetpackhiltdemo.ui.main.adapter.RepositoriesAdapter
import com.app.jetpackhiltdemo.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var repositoriesAdapter: RepositoriesAdapter
    private val repositoryObserver = Observer<ResultData<RepositoriesModel?>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
                progressIndicator.show()
            }
            is ResultData.Success -> {
                progressIndicator.hide()
                val repositoriesModel = resultData.data
                repositoriesAdapter.submitList(repositoriesModel)
            }
            else -> {
                progressIndicator.hide()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repositoriesAdapter = RepositoriesAdapter()
        recycler_view_repositories.adapter = repositoriesAdapter

        swipe_refresh.setOnRefreshListener(this)

        setObservers()
        getDataAndSubscribeEvents()
    }

    private fun setObservers() {
        mainViewModel.repositoryListLiveData.observe(this, repositoryObserver)
    }

    private fun getDataAndSubscribeEvents() {
        mainViewModel.getRepositoriesList(since = "20")
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = false
        getDataAndSubscribeEvents()
    }
}