package com.narinc.base.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import com.narinc.base.R
import com.narinc.base.data.model.Item
import com.narinc.base.databinding.FragmentDetailBinding
import com.narinc.base.ui.SpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val item: Item by lazy { args.item }
    private val viewModel: DetailViewModel by hiltNavGraphViewModels(R.id.navigation_graph)
    private lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.data = item
        binding.vm = viewModel
        binding.rvEpisodes.addItemDecoration(
            SpaceItemDecoration.newInstance(
                requireContext(),
                16,
                8
            )
        )
        binding.rvEpisodes.adapter = EpisodesAdapter(item.episode)
        

        return binding.root
    }
}