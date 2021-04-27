package com.narinc.base.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import com.narinc.base.R
import com.narinc.base.databinding.FragmentHomeBinding
import com.narinc.base.ui.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
@ExperimentalPagingApi
class HomeFragment : Fragment() {

    private var job: Job? = null
    private val viewModel: HomeViewModel by hiltNavGraphViewModels(R.id.navigation_graph)
    private lateinit var binding: FragmentHomeBinding
    lateinit var adapter: HomePageAdapter

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        getDataAndNotifyAdapter()
        return binding.root
    }

    private fun initAdapter() {
        adapter = HomePageAdapter()
        binding.rvItems.addItemDecoration(SpaceItemDecoration.newInstance(requireContext(), 8))
        binding.rvItems.adapter = adapter

        adapter.addLoadStateListener { loadState ->
            binding.rvItems.isVisible = loadState.refresh is LoadState.NotLoading
            binding.progress.isVisible = loadState.refresh is LoadState.Loading
            manageErrors(loadState)
        }
    }

    private fun getDataAndNotifyAdapter() {
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.loadCharacters().collectLatest { adapter.submitData(it) }
        }
    }

    private fun manageErrors(loadState: CombinedLoadStates) {
        binding.errorText.isVisible = loadState.refresh is LoadState.Error
        binding.retryButton.isVisible = loadState.refresh is LoadState.Error
        binding.retryButton.setOnClickListener { adapter.retry() }

        val errorState = loadState.source.append as? LoadState.Error
            ?: loadState.source.prepend as? LoadState.Error
            ?: loadState.append as? LoadState.Error
            ?: loadState.prepend as? LoadState.Error

        errorState?.let {
            val errorText = resources.getString(R.string.error) + it.error.toString()
            binding.errorText.text = errorText
        }
    }
}