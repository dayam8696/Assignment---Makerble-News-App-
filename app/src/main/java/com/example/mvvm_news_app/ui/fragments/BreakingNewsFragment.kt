package com.example.mvvm_news_app.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_news_app.R
import com.example.mvvm_news_app.adapters.NewsAdapter
import com.example.mvvm_news_app.databinding.FragmentBreakingNewsBinding
import com.example.mvvm_news_app.ui.NewsActivity
import com.example.mvvm_news_app.ui.NewsViewModel
import com.example.mvvm_news_app.util.Resource
import kotlin.math.log

class BreakingNewsFragment:BaseFragment() {
    private val binding by lazy { FragmentBreakingNewsBinding.inflate(layoutInflater) }
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter :NewsAdapter
    val TAG = "BreakingNewsFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewmodel
        viewModel.getBreakingNews("us")
        setupRecycleView()


        newsAdapter.onItemClickListener = {
          ArticleFragment.article =it
           navigateTo(R.id.action_breakingNewsFragment_to_articleFragment)
        }
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {
            response ->
            when(response){
                is Resource.Success -> {

                    hideProgressBar()
                    response.data?.let { newRespone ->
                        newsAdapter.differ.submitList(newRespone.articles)
                        Log.d("javed", newRespone.articles.toString())
                    }
                }
                is Resource.Error -> {
                    Log.d("javed", "onViewCreated: error aagya")

                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG ,"An error occured : $message")
                    }

                }

                is Resource.Loading -> {
                    Log.d("javed", "onViewCreated: loading aagya")
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }


    private fun setupRecycleView(){
        newsAdapter = NewsAdapter()
        binding.rvBreakingNews.apply {
            adapter =newsAdapter
           layoutManager = LinearLayoutManager(activity)
        }
    }
}